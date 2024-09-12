// Worst case Time Complexity : O(n) where in this case n <= 1000
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes


// Your code here along with comments explaining your approach
/* Create hash chain using linked list. 
 * Create 10^4 buckets. And use following hash function to find bucket for value - value % 10^4.
 * For put :- Find bucket using hash function, if bucket is empty then create a new linked list starting with dummy node.
 * For get :- Find bucket using hash function, then perform linear search on linked list and return its value.
 * For remove :- Find bucket using hash function, and then adjust the linked list pointers to delete node.
 * findPrevious() returns previous pointer, used to keep solution modular.
 */


#define getBucket(key)  key % 10000

class MyHashMap {
public:
        
    struct Node
    {
        int key;
        int value;
        Node* next;
    };
    
    Node* createNode(int key, int value)
    {
        Node* newNode = new Node;    
        newNode->key = key;
        newNode->value = value;
        newNode->next = NULL;
        return newNode;
    }
    
    Node* map[10000];
    
    MyHashMap() {
        for (int i = 0; i < 10000; i++)
        {
            map[i] = NULL;
        }
    }
    
    Node* findPrevious(Node* n, int key)
    {
        Node* prev = n;
        Node* cur = prev->next;
        
        while (cur != NULL && cur->key != key)
        {
            prev = prev->next;
            cur = cur->next;
        }
        return prev;
    }
    
    void put(int key, int value) {
        int bucket = getBucket(key);
        
        if (map[bucket] == NULL)
        {
            Node* node = createNode(-1, -1);
            map[bucket] = node;
        }
        
        Node* prev = findPrevious(map[bucket], key);
        
        if (prev->next == NULL)
        {
            prev->next = createNode(key, value);
        }
        else 
        {
            prev->next->value = value;
        }
        
    }
    
    int get(int key) {
        int bucket = getBucket(key);
        if (map[bucket] == NULL)
        {
            return -1;
        }
        
        Node* prev = findPrevious(map[bucket], key);
        
        if (prev->next == NULL)
        {
            return -1;
        }
        
        return prev->next->value;
    }
    
    void remove(int key) {
        int bucket = getBucket(key);
        if (map[bucket] == NULL)
        {
            return;
        }
        
        Node* prev = findPrevious(map[bucket], key);
        
        if (prev->next == NULL)
        {
            return;
        }
        
        Node* temp = prev->next;
        prev->next = prev->next->next;
        
        delete temp;
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */
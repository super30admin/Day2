// to design the hashmap we basically need to understand the hashing :- so hashing means maping the
// key with hash function to memory registarion with hash code
// now the primary data structure used for the hash map can be the array as it helps us access each 
// variables with that index
// if we perform 1:1 mapping on the given data strcuture , the required data structure length would be 
// the maximum length of the expected output in this case 10^6
// so we can use a different hash function
// primart hash function - key%length
// but it will introduce the problem of collition
// we can address this which several techniques
// 1. linear probing
// 2. quadratic probing
// 3. BST chaining
// 4. Linear chaining
// 5. double hashing

// let us implement the second hash function with the linear chaining 
// we will create the first data strcutre of the size 1000 as we want to balance the size and the
// time it will require to itrate through each value pairs .

class MyHashMap {
public:
    
    struct Node
    {
        int val;
        int key;
        Node *next;
    };
    
    Node* storage[10000];
    int buckets;
    MyHashMap() {
        this->buckets = 10000;
        for(int i = 0 ; i < buckets; i++)
        {
            storage[i]= nullptr;
        }
    }
    
    int primaryFunction(int key){
        return key%buckets;
    }
    Node *getPrevNode(int primaryIndex, int key){
        Node *curr = storage[primaryIndex];
        Node *prev = NULL;
        while(curr != NULL && curr->key !=key)
        {
            prev = curr;
            curr = curr->next;
        }
        return prev;
    }
    void put(int key, int value) {
        // now to add the value to the we will need to check the hash function
        int primaryIndex = primaryFunction(key);
        if(storage[primaryIndex] == NULL)
        {
            Node *dummy = new Node;
            dummy->val = -1;
            dummy->key = -1;
            dummy->next = NULL;
            storage[primaryIndex] = dummy;

            // now add a new node to that dummy node
            Node *new_node = new Node;
            new_node->key = key;
            new_node->val = value;
            new_node -> next = NULL;
            storage[primaryIndex]->next = new_node;
        }
        Node *prev = getPrevNode(primaryIndex,key);

        if(prev->next == NULL)
        {
            Node *new_node = new Node;
            new_node->key = key;
            new_node->val = value;
            new_node -> next = NULL;
            prev->next = new_node;
        }
        else
        {
            prev->next->val = value;
        }

    }
    
    int get(int key) {
        // to get the value based on the key we will need to see if it is intialized
        int primaryIndex = primaryFunction(key);
        if(storage[primaryIndex] == NULL)
            return -1;
        Node *prev = getPrevNode(primaryIndex,key);
        if(prev->next == NULL)
            return -1;
        return prev->next->val;
    }
    
    void remove(int key) {
        // to remove we will need to first find the element
        int primaryIndex = primaryFunction(key);
        if(storage[primaryIndex] == NULL)
            return;
        Node *prev = getPrevNode(primaryIndex,key);
        if(prev->next == NULL)
            return;
        //found it
        Node *temp = prev->next;
        prev->next = temp->next;
        temp->next = NULL;
    
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */
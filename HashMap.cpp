// Time Complexity : put, get, remove: O(n), because findPrevNode should traverse entire linked list
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no. Got to know that we need a dummy node to get the 
//                                           previous nodes which are useful for removal of nodes 
//                                           and updating values if key already exists in the map.
//                                           Since we're using a Singly Linked List we need previous 
//                                           node to remove the actual key holding node or update 
//                                           the value of the key holding node. If I have had a 
//                                           Doubly Linked List then we need not have a dummy node.


// Your code here along with comments explaining your approach

#define BUCKETS 1000
class MyHashMap {

    class Node
    {
        public:
            int key;
            int value;
            Node* next;

            Node(int k, int v)
            {
                this->key = k;
                this->value = v;
                this->next = NULL;
            }
    };
    
    Node** hash_map;

    int getBucket(int key)
    {
        return key%BUCKETS;
    }

    // Given a key and bucket this function,
    //    if key exists, returns previous node to the Node that holds key,
    //    if not, returns last node in the linked list
    Node* findPrevNode(int key, int bucket)
    {
        Node* curr = hash_map[bucket];
        Node* next = curr->next;
        while(next!=NULL)
        {
            if(next->key == key)
            {
                return curr;
            }
            curr = next;
            next = next->next;
        }
        return curr;
    }

public:
    MyHashMap() {
        hash_map = new Node*[BUCKETS];
        for (int i=0; i<BUCKETS; i++)
            hash_map[i] = NULL;
    }
    
    void put(int key, int value) {
        int bucket = getBucket(key);
        if (hash_map[bucket] == NULL)
        {
            // Create a new dummy node since this bucket isn't used so far
            Node* dummy_node = new Node(-1, -1);
            hash_map[bucket] = dummy_node;
        }
        // If bucket exists, check if key exists in the map
        Node* node = findPrevNode(key, bucket);
        // If key exists in hashmap
        if(node->next != NULL)
            node->next->value = value;
        // If key doesn't exist
        else
            node->next = new Node(key, value);
    }
    
    int get(int key) {
        int bucket = getBucket(key);
        if (hash_map[bucket] != NULL)
        {
            Node* node = findPrevNode(key, bucket);
            if(node->next != NULL)
            {
                return node->next->value;
            }
        }
        return -1;
    }
    
    void remove(int key) {
        int bucket = getBucket(key);
        if (hash_map[bucket] != NULL)
        {
            Node* node = findPrevNode(key, bucket);
            if(node->next != NULL)
            {
                node->next = node->next->next;
            }
        }
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */
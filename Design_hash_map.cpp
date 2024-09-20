class MyHashMap {
    int buckets;
    
    //define the node
    class Node{
        public:
        int key;
        int value;
        Node *next;
         
        //constructor
        public: Node(int key, int value) {
            this->key = key;
            this->value = value;
            this->next = nullptr;
        } 
    };

Node **storage;


public:
    MyHashMap() {
        this->buckets = 10000;
        this->storage = new Node*[buckets];
        for (int i=0; i<buckets; i++)
           storage[i] = nullptr;
    }
    
    private: int getHash(int key) {
       return key % buckets;
    }
    
    private: Node *getPrev(Node *head, int key) {
        Node *prev = NULL;
        Node *curr = head;

        while (curr != nullptr && curr->key!=key) {
            prev = curr;
            curr = curr->next;
        }
        return prev;
    }
    public:
    void put(int key, int value) {
        //first go to the primary bucket
        int hash = getHash(key);
        if ( storage[hash] == NULL) {
            storage[hash] = new Node (-1,-1);
        }
        Node *prev = getPrev(storage[hash], key);
        if (prev->next == nullptr) { //new node
            prev->next = new Node (key, value);
        } else 
        {
            prev->next->value = value; //existing node
        }
    }

    
    int get(int key) {
        int hash = getHash(key);
        if ( storage[hash] == NULL) {
            return -1;
        }
        Node *prev = getPrev(storage[hash], key);
        if (prev->next == NULL) //node doesn't exist
            return -1;
        else
            return prev->next->value; //existing node

    }
    
    void remove(int key) {
         int hash = getHash(key);
        if ( storage[hash] == NULL) {
            return;
        }

// Find the previous node
        Node *prev = getPrev(storage[hash], key);
        // If the next node is null, the key doesn't exist
        if (prev->next == nullptr) {
            return;
        }
        // Unlink the node from the linked list
        Node *toDelete = prev->next;
        prev->next = prev->next->next;
        delete toDelete; // Free the memory
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */

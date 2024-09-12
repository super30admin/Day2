class MyHashMap {
    class node{
    public:
        int key, val;
        node *next;
        node(int key, int val){
            this->key = key;
            this->val = val;
            this->next = NULL;
        }
    };
    node** nodes;
    int size;
    int getKey(int key){
        return key % size;
    }
     node* find(node *head, int key){
        node *prev = NULL;
        node *curr = head;
        while(curr != NULL && curr->key != key){
            prev = curr;
            curr = curr->next;
        }
        return prev;
    }
    public:
    /** Initialize your data structure here. */
    MyHashMap() {
        size = 10000;
        nodes = new node*[size];
        for(int i = 0; i < size; i++) {
            nodes[i] = NULL;
        }
    }
    /** value will always be non-negative. */
    void put(int key, int value) {
        int index = getKey(key);
        if(nodes[index] == NULL){
            nodes[index] = new node(-1, -1);
        }
        node* prev = find(nodes[index], key);
        if(prev->next == NULL){
            prev->next = new node(key, value);
        }
        else{
            prev->next->val = value;
        }
    }
   
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    int get(int key) {
        int index = getKey(key);
        node* idx = nodes[index];
        if(idx == NULL){
            return -1;
        }
        node* prev = find(idx, key);
        if(prev->next == NULL){
            return -1;
        }
        return prev->next->val;
    }
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    void remove(int key) {
        int index = getKey(key);
        node* idx = nodes[index];
        if(idx == NULL){
            return;
        }
        node* prev = find(idx, key);
        if(prev->next == NULL){
            return;
        }
        prev->next = prev->next->next;
    }
};

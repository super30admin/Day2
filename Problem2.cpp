//Design Hashmap (https://leetcode.com/problems/design-hashmap/)
// Time Complexity : O(k) where k is the number of buckets
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashMap {
public:
    struct Node{
        int key;
        int value;
        Node *next;
        Node(int key, int value){
            this->key = key;
            this->value = value;
            this->next = NULL;
        }
    };
    vector<Node*> nodes;
    int buckets;
    
    //hashing function
    int getbucket(int key){
        return key%buckets;
    }
    
    MyHashMap() {
        buckets = 10000;
        //created a vector of Nodes
        nodes = vector<Node*>(buckets);  
    }
    
    
    Node* find(Node *head, int key){
        Node *prev = head;
        Node *curr = head->next;
        while(curr!=NULL && curr->key!=key){
            prev = curr;
            curr=curr->next;
        }
        return prev;
    }
    
    void put(int key, int value) {
        int bucket = getbucket(key);
        if(nodes[bucket] == NULL){
            nodes[bucket] = new Node(-1,-1);
        }
        Node *prev = find(nodes[bucket], key);
        if(prev->next == NULL){
            prev->next = new Node(key, value);
        }else{
            prev->next->value = value;
        }
    }
    
    int get(int key) {
        int bucket = getbucket(key);
        if(nodes[bucket] == NULL){
            return -1;
        }
        Node *prev = find(nodes[bucket], key);
        if(prev->next == NULL){
            return -1;
        }
        return prev->next->value;
    }
    
    void remove(int key) {
        int bucket = getbucket(key);
        if(nodes[bucket] == NULL){
            return;
        }
        Node *prev = find(nodes[bucket], key);
        if(prev->next == NULL){
            return;
        }
        else prev->next=prev->next->next; 
        
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */
// Design HashMap
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Approach
// Will use Linkedlist and linear chaining. Create a hash() & find() to keep track of prev.
// then in all put, find remove we will have 3 conditions. 1)If LL is present no not.
// 2) if prev node found and we are at the last node. 3) if prev node found and next node is also exist.

// TC: O(1) average and O(n) worst case - for all get(),put() and remove() methods.
// SC: O(n) - where n is the number of entries in HashMap 
// we are using double hashing, array of nodes (10^4) & LL (10^2) as there are total 10^6 data, we divide in this way to achieve O(1) as search in LL, as O(100) ~ O(1)
class MyHashMap {
public:
    class Node {
    public:
        int key;
        int value;
        Node* next;

        Node(int key, int value) {
            this->key = key;
            this->value = value;
            this->next = nullptr;
        }
    };
    // make a vector of Node*
    vector<Node*> nodes;

    MyHashMap() {
        nodes.resize(10000); // 10^4 size of Array   
    }
    
    int hash(int key) {
        return key % 10000; // hashing it through the array
    }
    // finding in the LL
    Node* find(Node* head, int key) {
        Node* prev = nullptr;
        Node* curr = head;
        while(curr != nullptr && curr->key != key) {
            prev = curr;
            curr = curr->next;
        }
        return prev; // returning prev as we are performing operations through prev.next
    }

    void put(int key, int value) {
        int index = hash(key);
        // making first dummy node to instantiate the LL in the nodes array
        if(nodes[index] == nullptr) nodes[index] = new Node(-1, -1);
        Node* prev = find(nodes[index], key);
        if(prev->next == nullptr) prev->next = new Node(key, value);
        else prev->next->value = value;
    }
    
    int get(int key) {
        int index = hash(key);
        if(nodes[index] == nullptr) return -1;
        Node* prev = find(nodes[index], key);
        if(prev->next == nullptr) return -1;
        return prev->next->value;
    }
    
    void remove(int key) {
        int index = hash(key);
        if(nodes[index] == nullptr) return;
        Node* prev = find(nodes[index], key);
        if(prev->next == nullptr) return;
        Node* toDel = prev->next;
        prev->next = prev->next->next;
        delete toDel;
    }

};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */
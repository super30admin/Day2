// Time Complexity : O(n)
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, I was facing an error accessing element from 
// vector of nodes. After some reasearch I have learnt the expectation vs my actual code.


// Your code here along with comments explaining your approach
// I created a structure for Linked list node and then created a vector of such Nodes of length 10000. 
// for every input, I calculate hash value and look for that index if it is null. if null then I Will create a
// dummy node to start with. Once I have that dummy node, I keep adding nodes. 
// I traverse through the linkedlist and see if the requested node is present, if present I will update value incase of
// put; I will get that value incase of get; I will remove that node and update link incase of remove. It is imporatant to
// handle corner cases where there is no such element to remove (this was one of the issues i faced while running the code).


#include <vector>
// Linkedlist node
struct Node {
    int key;
    int val;
    Node* next;
    Node(int k, int v)
        : key(k)
        , val(v)
        , next(nullptr)
    {

    }

    Node()
    : key(-1)
    , val(-1)
    , next(nullptr)
    {
    }
};

class MyHashMap {
private:
    #define BUCKETS 10000U
    
    int hash_func(int key)
    {
        return key%BUCKETS;
    }

public:
    std::vector<Node*> storage;
    MyHashMap() {
        storage.resize(BUCKETS, nullptr);
    }
    Node* find(Node* node, int key) {
        Node* curr = node;
        Node* prev = nullptr;
        
        while(curr != nullptr && curr->key != key)
        {
            prev = curr;
            curr = curr->next;
        }
        return prev;
    }
    void put(int key, int value) {
        int idx = hash_func(key);

        if(storage[idx] == nullptr)
        {
            // create a dummy node
            Node* dummy = new Node();
            storage[idx] = dummy;
        }
        Node* prev = find(storage[idx], key);
        if(prev->next == nullptr)
        {
            prev->next = new Node(key, value);
        }
        else
        {
            prev->next->val = value;
        }
        return;
    }
    
    int get(int key) {
        int idx = hash_func(key);
        if(storage[idx] == nullptr)
        {
            return -1;
        }
        Node* prev = find(storage[idx], key);
        if(prev->next == nullptr)
        {
            return -1;
        }
        return prev->next->val;
    }
    
    void remove(int key) {
        int idx = hash_func(key);
        if(storage[idx] == nullptr)
        {
            return;
        }
        Node* prev = find(storage[idx], key);
        if(prev->next == nullptr)
        {
            return;
        }
        Node* temp = prev->next;
        prev->next = prev->next->next;
        temp->next = nullptr;
        return;
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */
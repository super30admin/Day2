
// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

#include <iostream>
#include <stack>

using namespace std;
class MyHashMap {
    class Node {
        public:
            int key;
            int val;
            Node* next;
            Node(int k, int v) : key(k), val(v){next = nullptr;}
    };
    private:
    const static int size=10000;
    Node* storage[size]={};

    int hash(int key) {
        return key%size;
    }

    Node* search(Node* head, int key) {
        Node* prev= head;
        Node* curr = head;

        while (curr!=nullptr && curr->key!= key ){
            prev = curr;
            curr = curr->next;
        }
        return prev;
    }
public:
    MyHashMap() {
    }
    
    void put(int key, int value) {
        int ind = hash(key);
        if (storage[ind] == nullptr) {
            Node* newN = new Node(-1, -1);
            storage[ind] = newN;
            newN->next = new Node(key, value);
        }
        else {
            Node* prev = search (storage[ind], key);
            if (prev->next == nullptr) {
                prev->next = new Node(key, value);
            }
            else {prev->next->val = value;
            }
        }
    }
    
    int get(int key) {
        int ind = hash(key);
        if (storage[ind] == nullptr) return -1;
        Node* prev = search (storage[ind], key);
        if (prev->next == nullptr) return -1;
        return prev->next->val;
    }
    
    void remove(int key) {
        int ind = hash(key);
        if (storage[ind] == nullptr) return;
        Node* prev = search(storage[ind], key);
        if (prev->next != nullptr) {
            Node* temp = prev->next;
            prev->next = temp->next;
            delete temp;
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
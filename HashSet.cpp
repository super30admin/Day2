#include <bits/stdc++.h>
#define BUCKETS 10000

using namespace std;


class MyHashSet {
    
private:
    class Node {
         
    public:
        int value;
        Node *next;

        Node() : value(-1), next(nullptr) {}
        Node(int value) : value(value),
                          next (nullptr) {}
    } *nodes;

public:
    /* Create buckets here. */
    MyHashSet()
    {
        nodes = new Node[BUCKETS] ();
    }

    /* Time complexity : O(1) */
    int index(int value)
    {
        return value % BUCKETS;
    }
    
    /* Time complexity : O(m) - m being number of colliosions
     * for a key. 
     */
    Node * find(Node *head, int value)
    {
        Node *cur = head, *prev = head;
        while ((cur != nullptr) && (cur->value != value)) {
            prev = cur;
            cur = cur->next;
        }
        
        return prev;
    }

    /* Value is assumed to be always non-negative. 
     * Time Complexity can be upto O(n) depending on the collsions
     */
    void add(int value)
    {
        int idx = index(value);
        if (nullptr == nodes[idx].next) {
            nodes[idx].next = new Node(value);
            return;
        }
        
        Node *prev = find(&nodes[idx], value);
        if (nullptr == prev->next) {
            prev->next = new Node(value);
        } else {
            prev->next->value = value;
        }
    }
    
    /* Returns the value to which the specified key is mapped, 
     * or -1 if this map contains no mapping for the key.
     * Value is assumed to be always non-negative. 
     * Time Complexity can be upto O(n) depending on the collsions
     */
    bool contains(int value)
    {
        int idx = index(value);
        if (nullptr == nodes[idx].next) {
            return false;
        }
        
        Node *prev = find(&nodes[idx], value);
        if (nullptr == prev->next) {
            return false;
        }
        
        return true;
    }
    
    /* Removes the mapping of the specified value key,
     * if this map contains a mapping for the key.
     * Value is assumed to be always non-negative. 
     * Time Complexity can be upto O(n) depending on the collsions
     */
    void remove(int value)
    {
        int idx = index(value);
        if (nullptr == nodes[idx].next) {
            return;
        }
        
        Node *prev = find(&nodes[idx], value);
        if (nullptr == prev->next) {
            return;
        }
        
        Node *temp = prev->next;
        prev->next = prev->next->next;
        delete temp;
    }
};

int main()
{
    MyHashSet m;

    m.remove(3);

    m.add(5);
    m.add(3);
    
    if (!m.contains(8)) {
        cout << "You need to add it first, dumbass! (<:" << endl;
    } else {
        cout << "You have a bug in your code, as always!" << endl;
    }

    m.remove(5);
    m.remove(3);

    return 0;
}

// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: Design Hashmap
// Approach: Array of Linked List
// Time Complexity:
//      Insert: Worst Case - O(n)
//      Remove: Worst Case - O(n)
//      Search: Worst Case - O(n)

class MyHashMap
{

private:
    // Linked List Node Structure
    struct Node
    {
        int key;
        int value;
        Node *next;
    };

    // Array Size for Bucket
    int bucketSize = 1000;

    // Array for Storage
    vector<Node *> storage;

public:
    MyHashMap() { storage.resize(bucketSize); }

    int getBucket(int key) { return key % bucketSize; }

    Node *find(Node *dummy, int key)
    {
        Node *prev = dummy;
        Node *curr = dummy->next;

        // Linear Search over LinkedList
        while (prev->next != nullptr && curr->key != key)
        {
            prev = curr;
            curr = curr->next;
        }

        return prev;
    }

    void put(int key, int value)
    {
        int bucket = getBucket(key);
        Node *prev;

        // Create Dummy Node if not present
        if (storage[bucket] == nullptr)
        {
            Node *dummy = new Node();
            dummy->key = -1;
            dummy->value = -1;
            dummy->next = nullptr;

            storage[bucket] = dummy;

            // Set Prev to Dummy node as there was no node present
            prev = dummy;
        }
        else
        {

            // Look for Position in Linked List to be placed or present
            prev = find(storage[bucket], key);
        }

        if (prev->next == nullptr)
        {

            // Create New Node if the key is not present
            Node *newNode = new Node();
            newNode->key = key;
            newNode->value = value;
            newNode->next = prev->next;

            // Point Prev to New Node
            prev->next = newNode;
        }
        else if (prev->next->key == key)
        {

            // If key is present, update the value
            prev->next->value = value;
        }
    }

    int get(int key)
    {
        int bucket = getBucket(key);

        Node *prev;

        // Check if the dummy node is present, if not return -1
        if (storage[bucket] == nullptr)
        {

            return -1;
        }
        else
        {
            // Find for the key in the Linked List
            prev = find(storage[bucket], key);
        }

        // Check if the node to be searched does exist after the prev, if not
        // retun -1
        if (prev->next == nullptr)
        {
            return -1;
        }

        return prev->next->value;
    }

    void remove(int key)
    {
        int bucket = getBucket(key);
        Node *prev;

        // Check if the dummy node is present, if not do nothing
        if (storage[bucket] == nullptr)
        {
            return;
        }
        else
        {
            prev = find(storage[bucket], key);

            // Check if the node to be searched does exist after the prev, if not retun -1
            if (prev->next == nullptr)
            {
                return;
            }
            else if (prev->next->key == key)
            {
                // Unlink the Node for the key to be deleted and set to deleted nodes next
                prev->next = prev->next->next;
            }
        }
    }
};

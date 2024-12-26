// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class MyHashMap
{
public:
    // Node structure to store data and address of next
    struct Node
    {
        int key, value;
        Node *next;
    };

    vector<Node *> store;
    int bucketSize = 1000;

    MyHashMap()
    {
        store.resize(bucketSize); // initialize vector to store value
    }

    // hash function to determine bucket
    int getBucket(int val)
    {
        return val % bucketSize;
    }

    // return the pointer prior to expected node value
    Node *findItem(int key, int bucket)
    {
        Node *prev = store[bucket];
        Node *curr = prev->next;

        while (curr != nullptr && curr->key != key)
        {
            curr = curr->next;
            prev = prev->next;
        }

        return prev;
    }

    void put(int key, int value)
    {
        int bucket = getBucket(key);
        // if the bucket is not created then create new to store the value
        if (store[bucket] == nullptr)
        {
            Node *temp = new Node(-1, -1);
            store[bucket] = temp;
            store[bucket]->next = new Node(key, value);
        }
        else
        {
            // check if the value exsits and update the exisiting if it returns a value or else then append the node
            int bucket = getBucket(key);
            Node *exists = findItem(key, bucket);
            if (exists->next != nullptr)
            {
                exists->next->value = value;
            }
            else
            {
                exists->next = new Node(key, value);
            }
        }
    }

    int get(int key)
    {
        int bucket = getBucket(key);
        // check if the bucket exists with the hash function
        if (store[bucket] != nullptr)
        {
            Node *exists = findItem(key, bucket);
            // check if the data exists with the provided key value
            if (exists->next != nullptr)
            {
                cout << "found " << key << endl;
                return exists->next->value;
            }
            else
            {
                return -1;
            }
        }
        return -1;
    }

    void remove(int key)
    {
        int bucket = getBucket(key);
        // check if the bucket exists
        if (store[bucket] != nullptr)
        {
            Node *temp = findItem(key, bucket);
            // remove data if the element is found
            if (temp->next == NULL)
            {
                return;
            }
            else if (temp->next->key == key)
            {
                temp->next = temp->next->next;
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
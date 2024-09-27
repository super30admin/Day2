// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class MyHashMap {

    

    //create a linked list node class

    class Node {

    

    public:

        Node *next;

        int key;

        int val;

        

        Node(int k, int v) {

            this->key = k;

            this->val = v;

            this->next = NULL;

        }

    };

    vector<Node*> vec;

    int bucket_num;



    

public:

    MyHashMap() {

        bucket_num = 1000;

        vec.resize(bucket_num);

    }



    int hash1(int key) {

        return (key % bucket_num);

    }

    

    //helper func to find the prev node:

    //returns prev node if node is present

    //returns tail if node is not present

    //returns null if vec[hash] is not present

    Node *prevNode(int key) {

        int h1 = hash1(key);

        if (vec[h1] == NULL) return NULL;

        

        Node *prev = vec[h1];

        Node *curr = prev->next;

        while(curr != NULL && curr->key != key) {

            prev = curr;

            curr = curr->next;

        }

        return prev;

    }

    

    void put(int key, int value) {

        Node *pr = prevNode(key);

        //case1 - where key itself is not present

        if (pr == NULL) {

            int h = hash1(key);

            vec[h] = new Node(key, value);

            pr = vec[h];

        }

        

        //tail node

        if (pr->next == NULL) {

            pr->next = new Node(key,value);

        }

        

        //case2 - where key is present. just update value

        else {

            pr->next->val = value;

        }

    }

    

    int get(int key) {

        Node *pr = prevNode(key);

        if (pr == NULL || pr->next == NULL) {

            return -1;

        } else return (pr->next->val);

    }

    

    void remove(int key) {

        Node *pr = prevNode(key);

        if (pr && pr->next != NULL) {

            pr->next = pr->next->next;

        }

    }

};

class MyHashSet {
public:
    /** Initialize your data structure here. */
    MyHashSet() {
        mySet = vector<list<int>>(128);
    }

    int GetHash(int key) {
        int h = hash<int>{}(key);
        int hash_mod = h % vec.size();
        return hash_mod;
    }


    void add(int key) {

    }

    void remove(int key) {

    }

    /** Returns true if this set contains the specified element */
    bool contains(int key) {

    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */

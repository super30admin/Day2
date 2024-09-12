class MyHashSet {
public:
    /** Initialize your data structure here. */
    MyHashSet() {
        hash = 1000;
        hashSet = std::vector<std::vector<bool>>(hash);
    }
    
    void add(int key) {     
        if(hashSet[key%hash].empty())
            hashSet[key%hash].resize(hash);
        hashSet[key%hash][key/hash] = true;
    }
    
    void remove(int key) {
        if(hashSet[key%hash].empty())
            return;
        else if(hashSet[key%hash][key/hash])
            hashSet[key%hash][key/hash] = false;
        else
            return;
    }
    
    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        if(hashSet[key%hash].empty())
            return false;
        else
            return hashSet[key%hash][key/hash];
    }
    
    private:
        int hash;
        std::vector<std::vector<bool>> hashSet;

};

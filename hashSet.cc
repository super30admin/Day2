// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class MyHashSet {
public:
    /** Initialize your data structure here. */
    std::vector<std::vector<bool>> *hashSet;
    int key1 = 1001;
    int key2 = 1000;
    MyHashSet() {
        hashSet = new std::vector<std::vector<bool>>(key1);
    }
    
    void add(int key) {
        if((*hashSet)[key % key1].empty()){
            (*hashSet)[key % key1].resize(key2);
            (*hashSet)[key % key1][key / key2] = true;
        }
        else{
            
            (*hashSet)[key % key1][key / key2] = true;
        }
    }
    
    void remove(int key) {
        if((*hashSet)[key % key1].empty())
            return;
        (*hashSet)[key % key1][key / key2] = false;
    }
    
    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        if((*hashSet)[key % key1].empty())
            return false;
        return (*hashSet)[key % key1][key / key2];
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */

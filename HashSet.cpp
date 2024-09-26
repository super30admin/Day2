// Time Complexity : O(1) for add, remove and contains
// Space Complexity : In the worst case I would use up 10^6 size if all the buckets got created
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope

class MyHashSet {
    vector<bool> hashSet[1000];
public:
    /** Initialize your data structure here. */
    MyHashSet() {
        
    }
    
    void add(int key) {
        int modVal = key % 1000;
        int divVal = key / 1000;
        
        if(hashSet[modVal].size() == 0){
            if(modVal == 0)
                hashSet[modVal] = vector<bool>(1001);
            else
                hashSet[modVal] = vector<bool>(1000);
        }
        
        hashSet[modVal][divVal] = true;
    }
    
    void remove(int key) {
        int modVal = key % 1000;
        int divVal = key / 1000;
        
        if(hashSet[modVal].size() == 0)
            return;
        
        hashSet[modVal][divVal] = false;
    }
    
    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        int modVal = key % 1000;
        int divVal = key / 1000;
        
        if(hashSet[modVal].size() == 0)
            return false;
        
        return hashSet[modVal][divVal];
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */
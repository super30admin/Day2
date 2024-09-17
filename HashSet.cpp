// Time Complexity :O(n) where n in the number elements in the bucket
// Space Complexity : O(n+k) where k is the total number of buckets 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashSet {
    int bucSize;
    vector<list<int>> storage;
public:
    /** Initialize your data structure here. */
    MyHashSet() {
        bucSize = 1000;
        storage = vector<list<int>>(bucSize,list<int>{});
    }
    int hash(int key){
        return key % bucSize; //compute hash value
    }
    //add to the list present at the index retrived from hash value
    void add(int key) {
        int i = hash(key);
        if(find(storage[i].begin(), storage[i].end(), key) == storage[i].end())
        { 
            storage[i].push_back(key);
        }
    }
    //remove from  the list present at the index retrived from hash value
    void remove(int key) {
        int i = hash(key);
        auto it = find(storage[i].begin(), storage[i].end(), key);
        if( it != storage[i].end())
            storage[i].erase(it);
    }
    
    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        int i = hash(key);
        if(find(storage[i].begin(), storage[i].end(), key) == storage[i].end())
            return false;
        else 
            return true;
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */
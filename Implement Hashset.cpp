// Time Complexity: O(N/K) where N is the number of possible values and K is the predefined bucket size
// Space Complexity: O(N+K) where N is the number of possible values and K is the predefined bucket size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : C++ syntax

class MyHashSet {
    int buckets;
    int bucketItems;
    vector<vector<bool>> storage;
public:
    /** Initialize your data structure here. */
    
    MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage.resize(buckets);
    }
    int hashset_1(int key){
        return key%buckets;
    }
    int hashset_2(int key){
        return key/bucketItems;
    }
    
    void add(int key) {
        int index1 = hashset_1(key);
        int index2 = hashset_2(key);
        if(storage[index1].size()==0){
            vector<bool> new_items(bucketItems);
            storage[index1] = new_items;
        }
        storage[index1][index2] = true;
        
    }
    
    void remove(int key) {
        int index1 = hashset_1(key);
        int index2 = hashset_2(key);
        if(storage[index1].size()==0){
            return;
        }
        else{
            storage[index1][index2] = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        int index1 = hashset_1(key);
        int index2 = hashset_2(key);
        if(storage[index1].size()==0){
            return false;
        }
        return storage[index1][index2];
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */

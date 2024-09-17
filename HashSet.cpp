// Time Complexity : add O(n) remove O(n) contains O(n)
// Space Complexity : O(n) for all; 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1. Maintain a vector of linkedlist to take the chaining approach
// 2. Here key is the value and use a hash code of 5 (can be set)
// 3. While adding/removing, check if element is already present and only then add

class MyHashSet {
public:
    /** Initialize your data structure here. */
    vector<list<int>> hash_set;
    int hash_code = 5;
    MyHashSet() {
        hash_set.resize(hash_code);
    }

    void add(int key) {
        int idx=key%hash_code;
        cout<<idx<<endl;
        if(find(hash_set[idx].begin(), hash_set[idx].end(), key) == hash_set[idx].end())
            hash_set[idx].push_back(key);
    }
    
    void remove(int key) {
        int idx=key%hash_code;
        if(find(hash_set[idx].begin(), hash_set[idx].end(), key) != hash_set[idx].end())
            hash_set[idx].remove(key);
    }
    
    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        int idx=key%hash_code;
        if(find(hash_set[idx].begin(), hash_set[idx].end(), key) != hash_set[idx].end())
            return true;
        return false;
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */

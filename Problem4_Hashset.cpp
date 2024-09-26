// Time Complexity :O(N/k) N=all possible numbers. k=number of predefined buckets
// Space Complexity :O(N+M) M=number of unique values inserted into the bucket
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Learnt it for the first time. 

//How do I make sure I do not forget them?


class MyHashSet {
    int numBuckets;
    vector<vector<int>> buckets;
    
    //hashing function
    int hashing_function(int key){
        return key%numBuckets;
    }
    
public:
    /** Initialize your data structure here. */
    MyHashSet() {
        numBuckets = 15000;
        buckets = vector<vector<int>>(numBuckets, vector<int>{});
    }
    
    void add(int key) {
        int i = hashing_function(key);
        if(find(buckets[i].begin(), buckets[i].end(),key)==buckets[i].end()){
            buckets[i].push_back(key);
        }
    }
    
    void remove(int key) {
        int i = hashing_function(key);
        auto it = find(buckets[i].begin(), buckets[i].end(),key);
        if(it!=buckets[i].end()){
            buckets[i].erase(it);
        }
    }
    
    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        int i = hashing_function(key);
        auto it = find(buckets[i].begin(), buckets[i].end(),key);
        if(it!=buckets[i].end()){
            return true;
        }
        else{
            return false;
        }
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */

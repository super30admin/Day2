// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Implmenting vector as dynamic array.


// Your code here along with comments explaining your approach

class MyHashSet {
public:
    /** Initialize your data structure here. */
    vector<vector<bool>>v;
    int buckets, bucketItems;
    MyHashSet() {
        buckets=1000;
        bucketItems=1000;
        v.resize(buckets);
    }
    int getBucket(int key){
        return key%buckets;        
    }
    int getBucketItem(int key){
        return key/bucketItems;        
    }
    void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(v[bucket].size()==0){
            if(bucket==0){
                v[bucket].resize(bucketItems+1);
            }
            else{
                v[bucket].resize(bucketItems);
            }
        }
        v[bucket][bucketItem]=true;
    }
    
    void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(v[bucket].size()==0){
            return;
        }
        v[bucket][bucketItem]=false;
    }
    
    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(v[bucket].size()==0){
            return false;
        }
        if(v[bucket][bucketItem]==true)
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
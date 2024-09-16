// Time Complexity : O(1)
// Space Complexity : O(1000*1000)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class MyHashSet {
    vector<vector<bool>> storage;
    int buckets;
    int bucketItems;
    int bucket(int key){
        return key%buckets;
    }
    int bucketItem(int key){
        return key/bucketItems;
    }
public:
    /** Initialize your data structure here. */
    MyHashSet() {
        buckets=1000;
        bucketItems=1000;
        storage.resize(buckets);
        //vector<vector<int>> storage(buckets); 
        //storage=new bool[buckets];
    }
    void add(int key) {
        int a=bucket(key);
        int b=bucketItem(key);
        if(storage[a].empty()){
            storage[a]=vector<bool> (bucketItems);
        }
        storage[a][b]= true;
    }
    void remove(int key) {
        int a=bucket(key);
        int b=bucketItem(key);
        if(storage[a].empty()) return;
        storage[a][b]=false;
    }
    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        int a=bucket(key);
        int b=bucketItem(key);
        if(storage[a].empty()) return false;
        return storage[a][b];
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */
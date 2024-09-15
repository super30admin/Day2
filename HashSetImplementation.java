// Time Complexity : O(1) for all funtions
// Space Complexity : O(n) where n is the size of the storeage i.e. buckets*bucketItems
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : edge case for storing 10^6 i.e. key which is the size of our storage

class MyHashSet {

    int buckets = 1000;
    int bucketItems = 1001;
    boolean[][] storage;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        storage = new boolean[buckets][];
    }
    
    public int getBucket(int key){
        return key%buckets;
    }
    
    public int getBucketItem(int key){
        return key/buckets;
    }
    
    public void add(int key) {
        int bucket = getBucket(key), bucketItem = getBucketItem(key);
        if(storage[bucket] == null) storage[bucket] = new boolean[bucketItems];
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = getBucket(key), bucketItem = getBucketItem(key);
        if(storage[bucket] == null) return;
        storage[bucket][bucketItem] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = getBucket(key), bucketItem = getBucketItem(key);
        if(storage[bucket] == null) return false;
        return storage[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
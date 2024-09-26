// Time Complexity : O(n/k) -> n: number of possible keys, k: number of predefined buckets
// Space Complexity : O(k + m) -> m: number of unique keys
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class MyHashSet {
    boolean[][] storage;
    int bucket;
    int bucketItems;

    /** Initialize your data structure here. */
    public MyHashSet() {
        this.bucket = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[bucket][];
    }
    
    private int bucket(int key) {
        return key % bucket;
    }
    
    private int bucketItems(int key) {
        return key / bucketItems;
    }
    
    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItems(key);
        if(storage[bucket] == null) {
            if(bucket == 0) {
                storage[bucket] = new boolean[bucketItems + 1];
            } else {
                storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItems(key);
        if(storage[bucket] == null)
            return;
        storage[bucket][bucketItem] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItems(key);
        if(storage[bucket] == null)
            return false;
        return storage[bucket][bucketItem];
    }
}
// Time Complexity : O(1) for add(), remove() and contains()
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope as this was disccused during the class


// Your code here along with comments explaining your approach
class MyHashSet {

    private boolean[][] storage;
    private int buckets;
    private int bucketItems;
    
    private int getBucket(int key) {
        return key % buckets;
    }
    
    private int getBucketItems(int key) {
        return key / bucketItems;
    }
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }
        
    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);
 
        if(storage[bucket] == null) {
            if(bucket == 0) {
                storage[bucket] = new boolean[bucketItems+1];
            } else {
                storage[bucket] = new boolean[bucketItems];
            }
        }
        
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);
        if(storage[bucket] == null)
            return;
        
        storage[bucket][bucketItem] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);
        return storage[bucket] == null ? false: storage[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
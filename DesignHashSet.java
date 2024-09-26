/**
 * TC: O(1)
 * SC: O(N)
 * LeetCode: Y(https://leetcode.com/problems/design-hashset)
 * Approach: Use double hashing (two hash functions).
 *           First hash function get the first index i.e. bucket number, second hash function will be the sub bucket number 
 
 */

class MyHashSet {

    int buckets;
    int bucketItems;
    boolean[][] storage;
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1001;
        storage = new boolean[buckets][];
    }
    
    public void add(int key) {
        int bucketNumber = hash1(key);
        
        if(storage[bucketNumber] == null) {
            storage[bucketNumber] = new boolean[bucketItems];
        }
        
        int subBucketNumber = hash2(key);
        
        // mark the place of key in storage to be true
        storage[bucketNumber][subBucketNumber] = true;
        
    }
    
    public void remove(int key) {
        int bucketNumber = hash1(key);
        
        if(storage[bucketNumber] == null) {
            return;
        }
        
        int subBucketNumber = hash2(key);
        
        // mark the place of key in storage to be false
        storage[bucketNumber][subBucketNumber] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketNumber = hash1(key);
        
        if(storage[bucketNumber] == null) {
            return false;
        }
        
        int subBucketNumber = hash2(key);
        
        // return the truth value of key in storage
        return storage[bucketNumber][subBucketNumber];
    }
    
    private int hash1(int key) {
        return key % buckets;
    }
    
    private int hash2(int key) {
        return key / buckets;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

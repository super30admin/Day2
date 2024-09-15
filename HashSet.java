// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class MyHashSet {
    int bucket;
    int bucketItems;
    
    boolean [][] storage;
    
    private int bucket(int key) {
        return key%bucket;
    }
    
    private int bucketItem(int key) {
        return key/bucketItems;
    }
    /** Initialize your data structure here. */
    public MyHashSet() {
        bucket = 1000;
        bucketItems = 1000;
        storage = new boolean[bucket][];
    }
    
    public void add(int key) {
        int bucket = bucket(key); //index in parent array
        int bucketItem = bucketItem(key); // index in my nested array at particular index
        
        if (storage[bucket] == null) {
            storage[bucket] = new boolean[bucketItems];
        }
        
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        
        if (storage[bucket] != null) {
            storage[bucket][bucketItem] = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucket(key); //index in parent array
        int bucketItem = bucketItem(key); // index in my nested array at particular index
        
        if (storage[bucket] != null) {
            return storage[bucket][bucketItem];
        }
        
        else {
            return false;
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
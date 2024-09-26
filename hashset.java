// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :

// I solved the problem after yesterday's class. I couldn't solve this on my own.

// Cannot colve problem by own.


// Your code here along with comments explaining your approach

class MyHashSet {

    boolean[][] storage;
    int buckets = 1000;
    int bucketItems = 1000;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        storage= new boolean[buckets][];
    }
    
    private int bucket(int key){
        return key % buckets;
    }
    
    private int bucketItem(int key){
        return key / bucketItems;
    }
    
    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null){
           storage[bucket] = new boolean[bucketItems]; 
        }
         storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] != null){
            storage[bucket][bucketItem] = false; 
        }
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        return storage[bucket] != null && storage[bucket][bucketItem] == true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
class MyHashSet {

    /** Initialize your data structure here. */
    private boolean[][] storage;
    private int buckets;
    private int bucketItems;
    
    //buckets initialized to their remainder
    private int bucket(int key){
        return key % buckets;
    }

    //buckets initialized to their quotient
    private int bucketItem(int key){
        return key / bucketItems;
    }
    
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1001;
        storage = new boolean[buckets][]; //No need to initialize columns as it will again initialize the entire 2D array
        
    }
    
    //TC: O(1)
    //SC: O(n)
    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null){
            storage[bucket] = new boolean[bucketItems];
        }
        storage[bucket][bucketItem] = true;
        
    }
    
    //TC: O(1)
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null){
            return;
        }
        storage[bucket][bucketItem] = false;
    }
    
    /** Returns true if this set contains the specified element */
    //TC: O(1)
    public boolean contains(int key) {
                int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null){
            return false;
        }
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
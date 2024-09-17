// Time Complexity : 
//add(), contains() and remove() : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class MyHashSet {
private int buckets;
    private int bucketItems;
    private boolean [][] storage;
    
    public int bucket(int key){
        return key % buckets;
    }
    
    public int bucketItem(int key){
        return key / bucketItems;
    }
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1001;
        storage = new boolean[buckets][];
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
        if(storage[bucket] == null) 
            return;
        storage[bucket][bucketItem] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null) 
            return false;
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
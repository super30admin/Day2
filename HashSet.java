// Time Complexity : O(n) where n is the number of values
// Space Complexity : O(m+k) where m is the number of buckets and k is the unique keys
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class MyHashSet {
    /** Initialize your data structure here. */
    private boolean[][] storage;
    private int buckets;
    private int items;
    
    private int bucket(int key){
        return key%buckets;
    }
    private int bucketItem(int key){
        return key/items;
    }
    
    public MyHashSet() {
        buckets = 1000;
        items = 1001;
        storage = new boolean[buckets][];
    }
    
    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        
        if(storage[bucket] == null){
            storage[bucket] = new boolean[items];
        }
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null) return;
        storage[bucket][bucketItem] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
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

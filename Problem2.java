// Time Complexity - O(1) for all operations
// Space Complexity - O(n)
// This Solution worked on LeetCode


class MyHashSet {
    int buckets = 1000; 
    int bucketItems = 1000;
    boolean[][] storage = new boolean[buckets][];
    /** Initialize your data structure here. */
    private int bucket(int key){
        return key % buckets;   
    }
    
    private int bucketItem(int key){
        return key / bucketItems;
    }
    public MyHashSet() {
           
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
        if(storage[bucket] != null){
            return storage[bucket][bucketItem];
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

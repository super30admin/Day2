class MyHashSet {

    /** Initialize your data structure here. */
    private boolean[][] storage;
    private int buckets;
    private int bucketItems;
    
    public MyHashSet() {
        buckets = 10000;
        bucketItems = 1001;
        storage = new boolean[buckets][];
    }
    
    // Time Complexity: O(1)
    // Space Complexity: O(n)
    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        
        if(storage[bucket] == null)
            storage[bucket] = new boolean[bucketItems];
        
        storage[bucket][bucketItem] = true;
    }
    
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] != null)
            storage[bucket][bucketItem] = false;
    }
    
    /** Returns true if this set contains the specified element */
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] != null)
            return storage[bucket][bucketItem];
        return false;
    }
    
    // Time Complexity: O(1)
    private int bucket(int key){
        return key % buckets;
    }
    
    // Time Complexity: O(1)
    private int bucketItem(int key){
        return key / bucketItems;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
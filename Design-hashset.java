class MyHashSet {
    
    int buckets=1000;
    int bucketItems=1000;
    boolean[][] storage = new boolean[buckets][];
    
    public int bucket(int value){
        return value%buckets;
    }
    
    public int bucketItems(int value){
        return value/buckets;
    }
    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItems(key);
        if(storage[bucket] == null) 
            /*
            Adding a new row at index bucket 
            in storage array with 1000 columns
            */
            storage[bucket] = new boolean[bucketItems];
        // Adding the key by setting storage to true
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItems(key);
        if(storage[bucket] != null)
            storage[bucket][bucketItem]=false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItems(key);
        
        return storage[bucket] != null && storage[bucket][bucketItem];
    }
}

// TC- O(1) for all operations
// SC- O(N)
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

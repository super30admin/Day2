class MyHashSet {

    int buckets = 1000;
    int bucketItems = 1000;
    
    boolean[][] storage = new boolean[buckets][];
    
    private int bucket(int value){
        return value/buckets;
    }
    
    private int bucketItems(int value){
        return value%bucketItems;
    }
    /** Initialize your data structure here. */
    public MyHashSet() {}
    
    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItems(key);
        if(storage[bucket] == null){
            storage[bucket] = new boolean[bucketItems];
        }
        storage[bucket][bucketItem] = true;
    }
    //time - O(1), space - O(1)
    
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItems = bucketItems(key);
        if(storage[bucket] != null){
            storage[bucket][bucketItems] = false;
        }
    }
    //time - O(1), space - O(1)
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItems = bucketItems(key);
        return storage[bucket] != null && storage[bucket][bucketItems];
    }
    //time - O(1), space - O(1)
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

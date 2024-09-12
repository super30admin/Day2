class MyHashSet {
    private boolean[][] storage;
    int buckets;
    int bucketsItems;

    /** Initialize your data structure here. */
    public MyHashSet() {
        storage = new boolean[1000][];
        buckets = 1000;
        bucketsItems = 1000;
    }
    private int bucket(int key){
        return key % buckets;
    }
    private int bucketItem(int key){
        return key / bucketsItems;
    }
    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null){
            if(bucket == 0){
                storage[bucket]  = new boolean[bucketsItems + 1];
            }else{
                storage[bucket]  = new boolean[bucketsItems];
            }
            
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
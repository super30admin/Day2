class MyHashSet {
    private boolean[][] storage;
    int buckets;
    int bucketItems;

    /** Initialize your data structure here. */
    public MyHashSet() {
        storage = new boolean[1000][];
        buckets=1000;
        bucketItems=1000;
    }
    
    private int bucket(int key){
        return key%buckets;
    }
    
    private int bucketItems(int key){
        return key/bucketItems;
    }
    
    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItems(key);
        if((storage[bucket]==null) && (bucket==0)){
            storage[bucket] = new boolean[1001];
        }
        
        if(storage[bucket] == null){
            storage[bucket] = new boolean[bucketItems];
        }
        storage[bucket][bucketItem] = true;
        
    }
    
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItems(key);
        if(storage[bucket] == null){
            return;
        }
        storage[bucket][bucketItem]=false;
        return; 
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItems(key);
        if(storage[bucket]==null){
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
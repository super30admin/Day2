class MyHashSet {
    public boolean [][] storage;
    public int bucket, bucket2;

    /** Initialize your data structure here. */
    public MyHashSet() {
        bucket = 1000;
        bucket2 = 1001;
        storage = new boolean [bucket][];
    }
    
    private int hash_one(int key){
        return key % bucket;
    }
    
    private int hash_two(int key){
        return key / bucket2;
    }
    
    public void add(int key) {
        int buckets = hash_one(key);
        int buckets2 = hash_two(key);
        if(storage[buckets] == null){
            storage[buckets] = new boolean [bucket2];
        }
        storage[buckets][buckets2] = true;
        
    }
    
    public void remove(int key) {
        int buckets = hash_one(key);
        int buckets2 = hash_two(key);
        if(storage[buckets] == null) return; 
        storage[buckets][buckets2] = false;    
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int buckets = hash_one(key);
        int buckets2 = hash_two(key);
        if(storage[buckets] != null) { return storage[buckets][buckets2]; }
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

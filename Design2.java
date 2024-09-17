class MyHashSet {
    boolean storage[][];
    int bucket;
    int bucketItems;

    public MyHashSet() {
        storage = new boolean[bucket][];
    }
    
    public int getBucket(int key){
        return key%1000;
    }
    
    public int getBucketItems(int key){
        return key/1000;
    }
    
    public void add(int key) {
        bucket= getBucket(key);
        bucketItems= getBucketItems(key);
        //java.lang.ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 0 - not sure why
        if(storage[this.bucket]==null){
            if (this.bucket == 0)
                {
                    storage[this.bucket] = new boolean[this.bucketItems + 1];
                }
                else
                {
                    storage[this.bucket] = new boolean[this.bucketItems];
                }
        }
        storage[this.bucket][this.bucketItems] = true;
    }
    
    public void remove(int key) {
        bucket = getBucket(key);
        bucketItems = getBucketItems(key);
        if(storage[this.bucket] == null){
          return;
        }
        storage[this.bucket][this.bucketItems] = false;
        
    }
    
    public boolean contains(int key) {
        bucket = getBucket(key);
        bucketItems = getBucketItems(key);
        if(storage[this.bucket] == null){
          return false;
        }
        return storage[this.bucket] [this.bucketItems];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
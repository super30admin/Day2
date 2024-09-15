class MyHashSet {

    boolean[][] storage;
    int buckets;
    int bucketItems;
    /** Bucket and bucketItems is used for hashing algorithm.
     * Storage is a 2 d boolean array which stores true if value is present false if not.
     * Implemented this using double hashing*/
    public MyHashSet() {
        this.storage=new boolean[1000][];
        this.bucketItems=1000;
        this.buckets=1000;
    }

    public int bucket(int key){
        return key%buckets;
    }

    public int bucketItems(int key){
        return key/bucketItems;
    }

    public void add(int key) {
        int bucket=bucket(key);
        int bucketItem=bucketItems(key);
        if(storage[bucket]==null){
            if(bucket==0){
                storage[bucket]=new boolean[bucketItems+1];
            }else{
                storage[bucket]=new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem]=true;
    }

    public void remove(int key) {
        int bucket=bucket(key);
        int bucketItem=bucketItems(key);
        if(storage[bucket]!=null){
            storage[bucket][bucketItem]=false;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket=bucket(key);
        int bucketItem=bucketItems(key);
        if(storage[bucket]!=null){
            if(storage[bucket][bucketItem]==true){
                return true;
            }
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
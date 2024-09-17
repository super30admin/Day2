class MyHashSet {
    int buckets=1000;
    int bucketItems=1001;
    boolean[][] storage=new boolean[buckets][];
    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    public int bucket(int key)
    {
        return key%buckets;
    }
    public int bucketItem(int key)
    {
        return key/bucketItems;
    }
    public void add(int key) {
        int bucket=bucket(key);
        int bucketItem=bucketItem(key);
        if(storage[bucket]==null)
        {
            storage[bucket]=new boolean[bucketItems];
        }
        storage[bucket][bucketItem]=true;
        
    }
    
    public void remove(int key) {
        int bucket=bucket(key);
        int bucketItem=bucketItem(key);
        if(storage[bucket]!=null)
        {
            storage[bucket][bucketItem]=false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket=bucket(key);
        int bucketItem=bucketItem(key);
        if(storage[bucket]==null) return false;
        else { 
            return storage[bucket][bucketItem];
        }
    }
}

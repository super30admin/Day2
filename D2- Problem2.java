class MyHashSet {
    
    boolean [][] storage;
    int buckets;
    int bucketitems;

    /** Initialize your data structure here. */
    public MyHashSet() {
        storage = new boolean[1000][];
        buckets = 1000;
        bucketitems = 1000;
        
    }
    
    private int bucket(int key)
    {
        return key%buckets;
    }
    
    private int bucketitem(int key)
    {
        return key/bucketitems;
    }
    
    public void add(int key) {
        int bucket = bucket(key);
        int bucketitem = bucketitem(key);
        if(storage[bucket] == null)
        {
            if(bucket ==0)
            {
            storage[bucket] = new boolean[bucketitems+1];
        }
            else
            {
                storage[bucket] = new boolean[bucketitems];
            }
        }
        
        storage[bucket][bucketitem] = true;
        
    }
    
    public void remove(int key) {
         int bucket = bucket(key);
        int bucketitem = bucketitem(key);
        if(storage[bucket] == null)
        {
            return;
        }
        storage[bucket][bucketitem] = false;
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketitem = bucketitem(key);
        if(storage[bucket] == null)
        {
            return false;
        }
        
        return storage[bucket][bucketitem];
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
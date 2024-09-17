class MyHashSet {
    
    private boolean[][] storage;
    private int bucket;
    private int bucketItems;

    public MyHashSet() {
        bucket = 1000;
        bucketItems = 1000;
        storage = new boolean[bucket][];
        
    }
    public int bucket(int key)
    {
        return key % bucket;
    }
    public int bucketItem(int key)
    {
        return key / bucketItems;
    }
    
    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null)
        {
            if(bucket == 0)
            {
                storage[bucket] = new boolean [bucketItems + 1];               
            }
            else
                storage[bucket] = new boolean [bucketItems];
        }
        storage[bucket][bucketItem] = true;
        
    }
    
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket]==null) return;
        storage[bucket][bucketItem] = false;   
    }
    
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket]==null) return false;
        return storage[bucket][bucketItem];      
        
    }
}

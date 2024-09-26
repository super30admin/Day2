class MyHashSet {
    int buckets = 1000;
    int bucketItems = 1000;
    boolean [][] storage = new boolean[buckets][];
    public MyHashSet() {
        
    }
    public int bucket(int value)
	{ 
       return value%buckets;
    }

    public int bucketItem(int value)
    { 
       return value/buckets;
    }
    public void add(int key) {
       int bucket = bucket(key);      
       int bucketItem = bucketItem(key);
       if(storage[bucket] == null)
       {
           if(bucket == 0)
               storage[bucket] = new boolean[bucketItems + 1];
           else
               storage[bucket] = new boolean[bucketItems]; 
       }
       storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = bucket(key);      
       int bucketItem = bucketItem(key);
       if(storage[bucket] == null) return;
       storage[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
       int bucket = bucket(key);      
       int bucketItem = bucketItem(key);
       if(storage[bucket] != null)
       {
           if(storage[bucket][bucketItem] == true)
             return true;
       }
       return false;
    }
}


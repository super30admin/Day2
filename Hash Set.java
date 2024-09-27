class MyHashSet {
    int buckets =1000;
    int bucketItems=1000;
    boolean [][] storage = new boolean[buckets][];
    /** Initialize your data structure here. */
    public int bucket(int index1)
    {
        return index1%buckets;
    }
    public int bucketItem(int index2)
    {
        return index2/bucketItems;
    }
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        int bucket =bucket(key);
        int bucketItem=bucketItem(key);
        if(storage[bucket]==null)
        {
            storage[bucket] = new boolean[bucketItems];
        }
        storage[bucket][bucketItem]=true;
    }
    
    public void remove(int key) {
     int bucket =bucket(key);
        int bucketItem=bucketItem(key);
        if(storage[bucket]!=null)
        {
        storage[bucket][bucketItem]=false;    
        }
        
    }   

    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
         int bucket =bucket(key);
        int bucketItem=bucketItem(key);
        return storage[bucket]!=null && storage[bucket][bucketItem];
    }
}


/**
 * Time Complexity 
 * add, remove, contain: O(1)
 * Space complexity :O(n)
 */
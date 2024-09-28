class MyHashMap {

    
    int[][] primary;
    int buckets;
    int bucketItems;
    
    public MyHashMap() {
        
        bucketItems=1000;
        buckets=1000;
        primary=new int[buckets][];
        
    }
    
    int hash1(int key)
    {
        return key%buckets;
    }
    
    int hash2(int key)
    {
        return key/bucketItems;
    }
    
    
    public void put(int key, int value) {
        
        int bucket=hash1(key);
        int bucketItem=hash2(key);
        
        if(primary[bucket]==null)
        {
            if(bucket==0)
                primary[bucket]=new int[bucketItems+1];
            else 
                primary[bucket]=new int[bucketItems];
            
            Arrays.fill(primary[bucket], 1000001);
        }
        
        
        primary[bucket][bucketItem]=value;
        
        
    }
    
    public int get(int key) {
        
        int bucket=hash1(key);
        int bucketItem=hash2(key);
        
        if(primary[bucket]==null)
        {
            return -1;
        }
        
        if(primary[bucket][bucketItem]==1000001)
            return -1;
        else return primary[bucket][bucketItem];
        
        
        
    }
    
    public void remove(int key) {
        
        int bucket=hash1(key);
        int bucketItem=hash2(key);
        
        if(primary[bucket]==null)
        {
            return;
        }
        
        primary[bucket][bucketItem]=1000001;
        

        
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
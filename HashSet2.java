
class MyHashSet {

    int buckets;
    int bucketItems;
    boolean[][] hashset;
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets =1000;
        bucketItems = 1001;
        hashset = new boolean[buckets][];
    }
    //hash 1
    private int bucket(int key){
        return key%buckets;
    }
    
    
    //hash 2
    private int bucketItem(int key){
        return key/bucketItems;
    }
    
    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        
        if(hashset[bucket] ==null)
            hashset[bucket] = new boolean[bucketItems];
        hashset[bucket][bucketItem] =true;
                    
    }
    
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        
        if(hashset[bucket] !=null)
            hashset[bucket][bucketItem] =false;
        return;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(hashset[bucket] ==null)
          return false;
        return hashset[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
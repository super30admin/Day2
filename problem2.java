//Hashset implemnetation
//27/32 use case passed

class MyHashSet {
    boolean[][] storage;
    int buckets;
    int bucketItems;


    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];    
    }
    
    private int getBucket(int key){
        return key%buckets;
    }
    private int getBucketItem(int key){
        return key%bucketItems;
    }




    public void add(int key) {
        int bucket =getBucket(key);
        int bucketItem = getBucketItem(key);
        if (storage[bucket]==null){
            if (bucket==0){
                storage[bucket] = new boolean[bucketItems+1];
            }else{
                storage[bucket]= new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem]=true;
    }
    
    public void remove(int key) {
        int bucket =getBucket(key);
        int bucketItem = getBucketItem(key);
        if (storage[bucket]==null){
            return;
        }
        storage[bucket][bucketItem]=false;
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket =getBucket(key);
        int bucketItem = getBucketItem(key);
        if (storage[bucket]==null){
            return false;
        }
        return storage[bucket][bucketItem];
    }
}
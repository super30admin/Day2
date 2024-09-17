class MyHashSet {
    // Time Complexity is O(1)
    // Space Complexity is O(n)
    // This solution is submitted on leetcode with no errors
    private boolean storage [][];
    int bucket;
    int bucketItems;

    public MyHashSet() {
        this.bucket = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[bucket][];
    }
    
    public int bucketHashFunc(int key){
        return key%bucket;
    }
    
    public int bucketItemsHashFunc(int key){
        return key/bucketItems;
    }
    
    public void add(int key) {
        int indxBucket = bucketHashFunc(key);
        int indxBucketItem = bucketItemsHashFunc(key);
        if(storage[indxBucket] == null) {
            if(indxBucket == 0) {
                storage[indxBucket] = new boolean[bucketItems +1];
            } else {
                storage[indxBucket] = new boolean[bucketItems];
            }
        }
        storage[indxBucket][indxBucketItem] = true;
    }
    
    public void remove(int key) {
        int indxBucket = bucketHashFunc(key);
        int indxBucketItem = bucketItemsHashFunc(key);
        if(storage[indxBucket] == null) return;
        storage[indxBucket][indxBucketItem] = false;
    }
    
    public boolean contains(int key) {
        int indxBucket = bucketHashFunc(key);
        int indxBucketItem = bucketItemsHashFunc(key);
        if(storage[indxBucket] == null) return false;
        return storage[indxBucket][indxBucketItem];
    }
}
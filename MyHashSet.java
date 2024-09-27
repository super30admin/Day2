// Time Complexity: O(1)
// Space Complexity: O(n)
class MyHashSet {

    private boolean[][] storage;
    private int buckets;
    private int bucket_items;
    /** Initialize your data structure here. */
    public MyHashSet() {
        this.buckets = 1000;
        this.bucket_items = 1000;
        this.storage = new boolean[buckets][];
    }
    
    //This function will return the hashed index for the bucket
    private int getBucketIndex(int key) {
        return key % buckets;
    }

    //This function will return the hashed index for the bucket items
    private int getBucketItemIndex(int key) {
        return key / bucket_items;
    }

    public void add(int key) {
    
        int bucket = getBucketIndex(key);
        int bucket_item = getBucketItemIndex(key);
        //If there is not items for a bucket, we will initalize storage for the bucket items
        if(storage[bucket] == null) {
            if(bucket == 0) {
                storage[bucket] = new boolean[bucket_items + 1];
            }
            else {
                storage[bucket] = new boolean[bucket_items];
            }
        }
        //if we already have bucket items for the buckets, we will add the other bucket item to the bucket;
        storage[bucket][bucket_item] = true;
    }
    
    public void remove(int key) {
        int bucket = getBucketIndex(key);
        int bucket_item = getBucketItemIndex(key);
        //If there is not items for a bucket, we will do nothing as there is nothing to remove
        if(storage[bucket] == null) { 
           //
        }
        //else we will assign false value to the bucketitem of bucket
        else {
            storage[bucket][bucket_item] = false;
        }

    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = getBucketIndex(key);
        int bucket_item = getBucketItemIndex(key);
        if(storage[bucket] == null) { 
            return false;
        }
        return storage[bucket][bucket_item];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
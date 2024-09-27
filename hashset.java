// Time Complexity : O(1) for add, remove and contains
// Space Complexity : worst case O(N) if all elements are inserted
// Did this code successfully run on Leetcode : Yes


class MyHashSet {
    
    private boolean[][] bucket_storage;
    private int buckets;
    private int bucketItems;
    
    private int bucket(int key){
        return key % buckets;
    }
    
    private int bucketItem(int key){
        return key / bucketItems;    
    }
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1001;
        bucket_storage = new boolean[buckets][];
    }
    
    public void add(int key) {
        int bucket_index = bucket(key);
        int bucket_item_index = bucketItem(key);
        if(bucket_storage[bucket_index] == null)
            bucket_storage[bucket_index] = new boolean[bucketItems];
        bucket_storage[bucket_index][bucket_item_index] = true;
    }
    
    public void remove(int key) {
        int bucket_index = bucket(key);
        int bucket_item_index = bucketItem(key);
        if(bucket_storage[bucket_index] == null)
            return;
        bucket_storage[bucket_index][bucket_item_index] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket_index = bucket(key);
        int bucket_item_index = bucketItem(key);
        if(bucket_storage[bucket_index] == null)
            return false;
        return bucket_storage[bucket_index][bucket_item_index];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
//Problem 2: Design Hashset
//Time Complexity : O(1)
//space complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Your code here along with comments explaining your approach
class MyHashSet {
    int bucket, bucketItems;
    boolean[][] hash_store;

    /** Initialize your data structure here. */
    public MyHashSet() {
        bucket = 1000;
        bucketItems = 1001;
        hash_store = new boolean[bucket][];
    }

    public int getBucket(int key){
        return key % bucket;
    }
    public int getBucketItems(int key){
        return key / bucketItems;
    }

    public void add(int key) {
        int bucket_key = getBucket(key);
        int bucketItem_key = getBucketItems(key);
        if(hash_store[bucket_key] == null){
            hash_store[bucket_key] = new boolean[bucketItem_key]; 
        }
        hash_store[bucket_key][bucketItem_key] = true;
    }

    public void remove(int key) {
        int bucket_key = getBucket(key);
        int bucketItem_key = getBucketItems(key);
        if(hash_store[bucket_key] == null){
            return;
        }
        hash_store[bucket_key][bucketItem_key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket_key = getBucket(key);
        int bucketItem_key = getBucketItems(key);
        if(hash_store[bucket_key] == null){
            return false;
        }
        return true;
    }
}
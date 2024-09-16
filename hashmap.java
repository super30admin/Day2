// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class MyHashSet {
    boolean[][] store;
    int buckets;
    int bucketItems;
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        store = new boolean[buckets][];
    }
    
    public int getBucket(int key){
        return key % 1000;
    }
    
    public int getBucketItems(int key){
        return key / 1000;
    }
    
    public void add(int key) {
        int buckets = getBucket(key);
        int bucketItem = getBucketItems(key);
        if (store[buckets] == null){
            if(buckets == 0){
                store[buckets] = new boolean[bucketItems + 1];
            }
            else{
                store[buckets] = new boolean[bucketItems];
            }
        }
        store[buckets][bucketItem] = true;
        
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);
        if(store[bucket] == null){
            return;
        }
        store[bucket][bucketItem] = false;
  
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItems = getBucketItems(key);
        if(store[bucket] == null){
            return false;
        }
        return store[bucket][bucketItems];
    }
}

// Time Complexity : O(1) for all approaches
// Space Complexity : O(n) if we store atleast one element in each bucket.
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : No, I felt double hashing is quite easy compared to chaining. Got an null pointer exception while i was trying, It got 
//cleared with Sanchit sir explanation.


// Your code here along with comments explaining your approach

class MyHashSet {
    
    int buckets;
    int bucketItems;
    boolean[][] storage;
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = 1001;
        bucketItems=1000;
        storage = new boolean[buckets][]; // buckets are guaranteed
    }
    
    public void add(int key) {
        //Time complexity: O(1) - All are constant operations, input independent
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);
        if(storage[bucket]==null){
            storage[bucket] = new boolean[bucketItems];
        }
        storage[bucket][bucketItem]= true;
    }
    
    public void remove(int key) { 
        //Time complexity: O(1) - All are constant opertions, input independent
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);
        if(storage[bucket]==null) return;
        storage[bucket][bucketItem]= false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        //Time complexity: O(1) - All are constant operations, input independent
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);
        if(storage[bucket]==null){
            return false;
        }
        return storage[bucket][bucketItem];
    }
    
    public int getBucket(int key){
        return key/buckets;
    }
    
    public int getBucketItems(int key){
        return key%bucketItems;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

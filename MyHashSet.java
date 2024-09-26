// Time Complexity : O(1) for all operations. 
// Space Complexity : O(N), where N can be upto 10^6.  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class MyHashSet {
    //each key will have their own place and to handle the edge case where key = 10^6, set bucketItems as 1001. 
    int buckets = 1000;
    int bucketItems = 1001;
    boolean[][] set;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        set = new boolean[buckets][]; 
    }
    
    public void add(int key) {
        int bucket = key%buckets;
        int bucketItem = key / buckets;
        //if bucket is null, initializing the bucket 
        if (set[bucket] == null)
            set[bucket] = new boolean[bucketItems];
        //adding the key to the set. 
        set[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = key%buckets;
        int bucketItem = key / buckets;
        //if bucket is null, key doesn't exists
        if (set[bucket] == null)
            return;
        //removing the key if it exists. 
        set[bucket][bucketItem] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = key%buckets;
        int bucketItem = key / buckets;
        //if bucket is null, key doesn't exists
        if (set[bucket] == null)
            return false;
        return set[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Using double hashing technique
class MyHashSet {

    private int buckets;
    private int bucketItems;
    private boolean [][] set;
    
    public MyHashSet() {
        buckets = 1000; // using bucket size as root of the requirements
        bucketItems = 1000;
        set = new boolean[buckets][]; // Initialize second array only if needed
    }
    
    private int getBucket(int key)
    {
        return key % buckets; // hash function 1
    }
    
    private int getBucketItem(int key)
    {
        return key / bucketItems; // hash function 2
    }
    
    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        
        if(set[bucket] == null) // first time seeing the hash index
        {
            if(bucket == 0)
            {
                set[bucket] = new boolean[bucketItems+1]; // when key = 10^6
            }
            else
                set[bucket] = new boolean[bucketItems]; 
        }
        
        set[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(set[bucket] == null) // never seen the value
        {
            return;
        }
        set[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
         if(set[bucket] == null) // never seen the value
        {
            return false;
        }
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
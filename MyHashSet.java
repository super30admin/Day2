// Time Complexity : O(1) 
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Used double hashing technique here with a 2-d boolean array
//we use two hash functions here for both inner array and outer array
//we make the value at the index as true whenever the key is added to the 2-d array and made false when removed
class MyHashSet {

    /** Initialize your data structure here. */
    private boolean[][] set;
    private int buckets;
    private int bucketItems;
    
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1001;
        set = new boolean[buckets][];
        
    }
    
    private int bucketHash(int key)
    {
        return key % buckets;
    }
    
    private int bucketItemHash(int key)
    {
        return key / bucketItems;
    }
    
    
    public void add(int key) {
        int bucket = bucketHash(key);
        int bucketItem = bucketItemHash(key);
        if(set[bucket]==null)
        {
            set[bucket] = new boolean[bucketItems];
        }
        set[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        
        int bucket = bucketHash(key);
        int bucketItem = bucketItemHash(key);
        if(set[bucket]==null)
        {
            return;
        }
        set[bucket][bucketItem]= false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucketHash(key);
        int bucketItem = bucketItemHash(key);
        if(set[bucket]==null)
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
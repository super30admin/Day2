// Time Complexity :O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Coded after the discussion in class


class MyHashSet {

    int buckets;
    int bucketItems;
    boolean [][] hashSet;
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = 1000;
        //To the max input of 10 ^6, the matrix should be 1000 X10001 or else when the 10^6 gets in will throw out of bound error
        bucketItems = 1001;
        //Only initialize the primary array /bucket and not the bucket item
        //otherwse it is like initializing the entire matrix
        //We need to initialize the corresponding bucket item array only when element come into the primary bucket.With that approach space complexity  will be O(N) 
            //this hasshet is a array of array

        hashSet = new boolean[buckets][];
    }
    
    //to calculate hash1
    private int bucket(int key)
    {
        return key%buckets;
    }
    
    //to calculate hash2
    
    private int bucketItem(int key) {
        return key/bucketItems;
    }
    
    public void add(int key) {
        
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        
        //Check if primary bucket is null
        if(hashSet[bucket] == null)
            //Initializing the nucketItem to 1001
            hashSet[bucket] = new boolean[bucketItems];
        hashSet[bucket][bucketItem] = true;
        
    }
    
    public void remove(int key) {
        
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        
        if(hashSet[bucket] == null)
            return;
        
        hashSet[bucket][bucketItem] = false;


    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        
        if(hashSet[bucket] == null)
            return false;
        return hashSet[bucket][bucketItem];
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

//  Design Hashset using double hashing

// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
/*
Approach:
1) went with the boolean matrix approach
2) implemented double hashing through % and / operations
*/

class MyHashSet {

    
    boolean storage[][];
    
    int bucket;
    int bucketItems;
    
    
    
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        
        bucket = 1000;
        bucketItems = 1000;
        
        storage = new boolean[bucket][]; //[][][][][]
                                          // []
                                          // []
    }
    
    public int getBucket(int key)
    {
        
        return key % bucket; // to find the initial buckets present in array
        
    }
    
    public int getBucketItems(int key)
    {
        return key / bucketItems; // to find bucketsItems attached to those buckets
    }
    
    
    
    
    
    public void add(int key) {
        
        int buckets = getBucket(key);
        int bucketsItem = getBucketItems(key);
        
        if(storage[buckets]==null) // no secondary array present to the corresponding bucket
        {
            // create a secondary array attached to the bucket
            if(buckets==0)
            {
                storage[buckets]= new boolean[bucketItems+1];
            }
            else
            {
                storage[buckets] = new boolean[bucketItems];
            }
        }
        
        storage[buckets][bucketsItem]=true;
        
    }
    
    public void remove(int key) {
     
        int buckets= getBucket(key);
        int bucketItem = getBucketItems(key);
        
        if(storage[buckets]==null)
        {
            return ;
        }
        storage[buckets][bucketItem]=false;
        
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int buckets= getBucket(key);
        int bucketItem = getBucketItems(key);
        
        if(storage[buckets]==null)
        {
            return false;
        }
        
        return storage[buckets][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
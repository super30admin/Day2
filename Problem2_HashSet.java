// Time Complexity : o(1)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashSet {

    int buckets=1000;
    int bucketItems=1001;
    boolean[][] hashSet;
    /** Initialize your data structure here. */
    public MyHashSet() {
        hashSet=new boolean[buckets][];
    }
    
    // getting index from buckets
    public int getBucket(int key)
    {
        return key%buckets;
    }

    // getting item index from list of array attached to bukcet index
     public int getBucketItem(int key)
     {
         return key/buckets;
     }
    
    public void add(int key) {
        int bucket=getBucket(key);
        int bucketItem=getBucketItem(key);
        
        if(hashSet[bucket]==null)
        {
            hashSet[bucket]=new boolean[bucketItems];
        }
        hashSet[bucket][bucketItem]=true;
    }
    
    public void remove(int key) {
        int bucket=getBucket(key);
        int bucketItem=getBucketItem(key);
        if(hashSet[bucket]!=null)
            hashSet[bucket][bucketItem]=false;
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket=getBucket(key);
        int bucketItem=getBucketItem(key);
        if(hashSet[bucket]!=null && hashSet[bucket][bucketItem]==true)
            return true;
        else
            return false;
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
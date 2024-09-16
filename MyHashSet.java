// Time Complexity : O(1) for every operation-> add,remove,bucket,bucketitem and contains
// Space Complexity :O(mn) -> For a 2D array of size in this case m is 10^3+1 and n is 10^3.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MyHashSet {

    /** Initialize your data structure here. */
    
    int bucket;
    int bucketItems;
    boolean storage[][];
    
    public MyHashSet() {
 
        bucket=1001;       // 1000 + 1 as 10^3 is range
        bucketItems=1000; // 10^3 is range
        storage= new boolean[bucket][];
        
    }
    
    
    public int bucket(int key){
        return key/bucket;   // hash function to compute bucket
    }
    
    public int bucketitem(int key){
        return key%bucketItems;   // hah function to compute bucketitem
    }
    
    public void add(int key) {
        
      int bucket=bucket(key);          // compute bucket position
        int bucketitem=bucketitem(key);  // compute bucketiem position
                                                  
        if(storage[bucket]==null)  { // check if it is empty then assign bucketitem to the bucket
            storage[bucket]=new boolean[bucketItems];
        }
        storage[bucket][bucketitem]=true; // assign value to true
    }
    
    public void remove(int key) {
        
        int bucket=bucket(key);          // compute bucket position
        int bucketitem=bucketitem(key);  // compute bucketiem position
        if(storage[bucket]==null) return; // return as key is not present as it wasnt assigned
        storage[bucket][bucketitem]=false; // unassign the value to false
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        
         int bucket=bucket(key);          // compute bucket position
        int bucketitem=bucketitem(key);  // compute bucketiem position
      
        if(storage[bucket]==null) return false;
       return storage[bucket][bucketitem]; // return true if filled else false if not filled
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
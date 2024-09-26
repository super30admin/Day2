//Leetcode problem : 705
// Time Complexity : O(1) for all functions
// Space Complexity : O(n*m)  where n and m is the size of primary and secondary array respectively
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach

class MyHashSet {
     
     //Took the size as 1000 as the maximum input range is 1000000. Hence, taking the sqaure root of maximum input range to avoid collisions
     int buckets = 1000; //intialize primary array size
     int bucketItems = 1000; //intialize secondary array size
     boolean [][] arr = new boolean[buckets][];  // 2-d array for double hashing with primary array size fixed, byt secondar array would only be initiated if there is an add operation and the primary array at that index has no value

    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        int hash1 = key % buckets; //first hash function
        int hash2 = key / buckets; //second hash function
         
        //if primary array has no value at that index, intialize secondary array 
        if(arr[hash1] == null)
            arr[hash1] = new boolean[bucketItems];
        
        //add true at that particular index in 2-D array
        arr[hash1][hash2] = true;
        
    }
    
    public void remove(int key) {
        int hash1 = key % buckets;
        int hash2 = key / buckets;
        
        //if primary array has no value at that index, nothing to remove
        if(arr[hash1] == null)
            return;
        
        arr[hash1][hash2] = false;
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash1 = key % buckets;
        int hash2 = key / buckets;
        if(arr[hash1] == null)
            return false;
        return arr[hash1][hash2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */


/*
Time Complexity:  O(1)
Space Complexity O(N + M), where n is the no of buckets and m is the size of the bucket 

Passed all test cases! 

Using 2 hash func method, we define boolean 2D array (rows are buckets indices and columns as bucket size) with only rows instantiated. 
Everytime we insert/add a value, we instantiate column and place a boolean true corresponding to the item index in the bucket. This helps us to achieve O(1)

*/

class MyHashSet {
    
    boolean [][] set ; 
    int numOfBuckets = 1000 ; 
    int numOfItemsInBuckets = 1000 ; 

    /** Initialize your data structure here. */
    public MyHashSet() {
        set = new boolean [numOfBuckets][] ; 
    }
    
    private int bucketIndex (int key) {
        return key % numOfBuckets ; 
    }
    
    private int itemBucketIndex (int key) {
        return key / numOfItemsInBuckets ; 
    }
    
    public void add(int key) {
        int bi = bucketIndex(key) ; 
        int ii = itemBucketIndex(key) ; 
        if (set[bi] == null) {
            set[bi] = new boolean[numOfItemsInBuckets] ;
        }
        set[bi][ii] = true ; 
    }
    
    public void remove(int key) {
         int bi = bucketIndex(key) ; 
        int ii = itemBucketIndex(key) ; 
        if (set[bi] != null) 
            set[bi][ii] = false; 
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
          int bi = bucketIndex(key) ; 
        int ii = itemBucketIndex(key) ;
        return set[bi] != null && set[bi][ii] == true ; 
    }
}


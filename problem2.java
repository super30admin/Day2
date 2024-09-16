// Time Complexity
// add: O(1)
// remove: O(1)
// contains: O(1)

// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * In this solution we will use Double hashing technique
 * The first hash function will be a modulo function
 * The second hash function will be a divide function
 * 
 * we will use the 2D boolean array with primary size 1000 and secondary size of 1000 buckets per index
 * 
 * If the key is added, we make the correct index in 2D array as true
 */
class MyHashSet {
    
    private boolean[][] hash_set;
    private int primary_bucket_size;
    private int secondary_bucket_size;
    /** Initialize your data structure here. */
    public MyHashSet() {
        primary_bucket_size = 1000;
        hash_set = new boolean[primary_bucket_size][];
        secondary_bucket_size = 1000;
    }
    
    /** returns primary bucket index **/
    public int first_hash(int key) {
        return key % primary_bucket_size;
    }
    
    public int second_hash(int key) {
        return key / secondary_bucket_size;
    }
    
    public void add(int key) {
        int first_hash = first_hash(key);
        
        if(hash_set[first_hash] == null) {
            if(first_hash == 0) {
                // this is a corner case when 1000000 is the input
                // we need one extra space in first index
                hash_set[first_hash] = new boolean[secondary_bucket_size + 1];
            } else {
                hash_set[first_hash] = new boolean[secondary_bucket_size];
            }
        }
        
        int second_hash = second_hash(key);
        
        hash_set[first_hash][second_hash] = true;
    }
    
    public void remove(int key) {
        int first_hash = first_hash(key);
        
        if (hash_set[first_hash] != null) {
            int second_hash = second_hash(key);
            hash_set[first_hash][second_hash] = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int first_hash = first_hash(key);
        
        if (hash_set[first_hash] == null) {
            return false;
        }
        
        int second_hash = second_hash(key);
        return hash_set[first_hash][second_hash] == true;
    }
}
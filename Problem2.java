//PROBLEM - Implement Hashset
/** 3 Pointer Approcach: 
 * 2d Arrrsy Boolean array.
 * 1D array (Bucket) will be indexed [1, 1K] for Val%1000
 * Each bucketItem array will be indexed for [1, 1K] from Val/1000
 * We wiil initialize bucketItem arrays on the fly when needed and not in start as they may not be used.
 * As it is given the numbers are in bound [1, 1M] so 1000 * 1000 will cover every number with NO collisions.
 * Why Boolean array? - beacause we just need to check if specific value is available in the HashSet boolean True means value present else not.
 * Approach - On Add item
 * key%1000 - will give the bucket-Index; key/1000 - will give the bucketItem-Index;
 */ 
//
//time Complexity :
// add - Best/Amotized/Worst:O(1)
// remove - Best/Amotized:O(1);
// contains - Best/Amotized:O(1);


// Space Complexity :
// O(Buckets * BucketItems).

// Did this code successfully run on Leetcode : YES.
// Any problem you faced while coding this : Regarding Time & Space complxity have some doubts, please let know
// whether I have calculated it correctly, if you would like to add any comments will be helpful.


class MyHashSet {

    int bucketArraySize = 1000; // Bucket
    int bucketItemArrsySize = 1000; // Bucket Item Size 
    
    boolean [][] bucket; // Bucket
        
    /** Initialize your data structure here. */
    public MyHashSet() {
        bucket = new boolean [bucketArraySize][];
    }
    
    public void add(int key) {
         int valHash1 = getBucketHash(key); // bucket-Index
         int valHash2 = getBucketItemHash(key); // bucketItem-Index
         if(bucket[valHash1] == null){
             bucket[valHash1] = new boolean[bucketItemArrsySize]; // if null only then create new item, to save memory foot prints
         }
        
        bucket[valHash1][valHash2] = true;
    }
    
    public void remove(int key) {   
         int valHash1 = getBucketHash(key);
         int valHash2 = getBucketItemHash(key);
         if(bucket[valHash1] != null){
             bucket[valHash1][valHash2] = false; // maintain boolean for hashes
         }
    }
    
    //2 1002 2002 3002 => 2
    //0 1 2 3
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
         int valHash1 = getBucketHash(key);
         int valHash2 = getBucketItemHash(key);
         if(bucket[valHash1] == null){
             return false;
         }
        
         return bucket[valHash1][valHash2];
    }
    
    private int getBucketHash(int val){
        return val%bucketArraySize;
    } 
    
    private int getBucketItemHash(int val){
        return val/bucketItemArrsySize;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
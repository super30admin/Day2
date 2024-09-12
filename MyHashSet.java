/*
 *  Time Complexity: O(1) for add, remove and contains operation since we are storing that info in the 2d array, we just need to calculate the hashKeys which takes constant time.
 *  Space Complexity: O(N) to store all the element in the 2d array.
 * 
 *  Did this code successfully run on Leetcode : Yes
 *  Any problem you faced while coding this : None
 * 
 *  Identify the bucket using the modulo function, then identify the bucket item index with the divide function, then mark that element in the 2d array with true. In order to remove the element we can remove mark the element as false. 
 */

class MyHashSet {

    /** Initialize your data structure here. */
    int buckets;
    int bucketItems;
    boolean[][] hashSet;
    public MyHashSet() {
        this.buckets=1000;
        this.bucketItems=1001;
        hashSet = new boolean[buckets][];
    }
    
    private int getBucket(int key){
        return key%this.buckets;
    }
    
    private int getBucketItem(int key){
        return key/this.bucketItems;
    }
    
    public void add(int key) {
        int bucketIndex = getBucket(key);
        int bucketItemIndex = getBucketItem(key);
        if(hashSet[bucketIndex]==null) hashSet[bucketIndex] = new boolean[bucketItems];
        
        hashSet[bucketIndex][bucketItemIndex] = true;
    }
    
    public void remove(int key) {
        int bucketIndex = getBucket(key);
        int bucketItemIndex = getBucketItem(key);
        if(hashSet[bucketIndex]==null) 
            return;
        hashSet[bucketIndex][bucketItemIndex] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketIndex = getBucket(key);
        int bucketItemIndex = getBucketItem(key);
        if(hashSet[bucketIndex]==null) 
            return false;
        return hashSet[bucketIndex][bucketItemIndex]; 
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

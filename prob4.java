// 705. Design HashSet
// S30 Big N Problem #4 {Easy}
// Time Complexity : O(1) for add(),remove(), contains()
// Space Complexity : worst case O(n*m) n*m=total values
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashSet {

    /** Initialize your data structure here. */
    int buckets = 1000;
    int bucketItems = 1000;
    boolean [][] storage = new boolean[buckets][]; //[,,,,,,,,] not [[,,,,,][,,,,,]]
    //only initialise nested array when req
    //hash functions
    private int bucket(int key){
        return key%buckets;
    }
    private int bucketItem(int key){
        return key/bucketItems;
    }
    
    public MyHashSet() {
        
    }
    
    public void add(int key) { // O(1)
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null){
            storage[bucket] = new boolean[bucketItems];
        }
        storage[bucket][bucketItem]=true;
    }
    
    public void remove(int key) { //O(1)
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] != null){
            storage[bucket][bucketItem] = false; 
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) { //O(1)
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket]!=null){
            return storage[bucket][bucketItem];
        }
        else{
            return false;
        } 
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
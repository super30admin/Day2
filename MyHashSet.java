import java.util.HashMap;

// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashSet {


    int buckets;
    int bucketItems;
    boolean[][] hashset;

    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1001; //to avoid runtime exception
        //we do not update bucket items yet to save space
        hashset = new boolean[buckets][]; 
    }
    
    //hashcode 1: modulus
    private int bucket(int key){
        return key % buckets;
    }

    //hashcode 2: division
    private int bucketItem(int key){
        return key / bucketItems;
    }

    public void add(int key) {
        //calculate the hashcodes
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        
        if(hashset[bucket] == null){
            hashset[bucket] = new boolean[bucketItems];
        }
        hashset[bucket][bucketItem] = true;
        
    }
    
    public void remove(int key) {
        //calculate the hashcodes    
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);

        if(hashset[bucket] == null){
            return;
        }
        hashset[bucket][bucketItem] = false;

    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        //calculate the hashcodes
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);

        if(hashset[bucket] == null){
            return false;
        }
        return hashset[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
package Design2;
//Time Complexity : O(1) for all operations
//Space Complexity : O(n) space worst case
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


//Your code here along with comments explaining your approach

class MyHashSet {
    
    boolean[][] storage;
    int buckets;
    int bucketItems;

    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }
    
    int bucket(int key){
        // initial hashfunction to get index
        return key % buckets;
    }
    
    int bucketItem(int key){
        // second hashing
        return key / bucketItems;
    }
    
    public void add(int key) {
        //getting values to store in bucket
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        
        if(storage[bucket] == null){
            // if 1000000 has to be put in 0th index, then create a new array with increasing size by 1
                storage[bucket] = new boolean[bucketItems+1];
            }//else mark it true
                storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        
        if(storage[bucket] == null) return;
        
        storage[bucket][bucketItem] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        
        if(storage[bucket] == null)return false;
        
        return storage[bucket][bucketItem];
    }
}

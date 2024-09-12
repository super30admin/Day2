// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
class MyHashSet {
    // Declaring the set of boolean array and index variables for that array.
    boolean [][] storage;
    int buckets;
    int bucketItems;

    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }
    // First hashing method using modulo to determine index for the primary array.
    private int bucket(int key){
        return key % buckets;
    }
    
    // Hash method using division to determine index for secondary array.
    private int bucketItem(int key){
        return key / bucketItems;
    }

    //Method for adding a key in the hashset.
    public void add(int key) {
        // calculating both the hashes for the given key.
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        // if the null at the inital array at calculated index then intializing the secondary array.
        if(storage[bucket] == null){
            // Initializing the secondary array with 1001 to avoid index out of bound if the calculated hash is 1000.
            if(bucket == 0){
                storage[bucket] = new boolean[bucketItems + 1];
            }
            else{
                storage[bucket] = new boolean[bucketItems];
            }
        }
        // marking the found cell.
        storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        // calculting both the hashes
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        // if null is found at intial array nothing needs to be done.
        if(storage[bucket] == null){
            return;
        }
        // Marks cell as false to remove the key.
        storage[bucket][bucketItem] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        // calculting both the hashes
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        // if null is found at intial array nothing needs to be done.
        if(storage[bucket] == null){
            return false;
        }
        // returns the boolean value at the calculated indexes.
        return storage[bucket][bucketItem];
    }
}
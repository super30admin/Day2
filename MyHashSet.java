// Time Complexity : With double hashing we ensured to identify index value for an element in a constant time, so performing add at index, removal from index and check if that item exists is constant time - O(1) 
// Space Complexity : For worst case if we need to push all elements in range 0-1000000 elements we need a 1000*1000 array to accomodate them which is equivalent to n - O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashSet {
    // Declared primary array size which will hold addresses to secondary arrays
    private int bucket;
    // Declared seconday array size which will hold values
    private int bucketItem;
    // Declared boolean array to hold true or false corresponding to specific key
    boolean [][] set;
    
    // hash function to evaluate index at primary array which will hold the array for this key
    // used modulus of bucket
    public int bucket(int key) {
        return key%bucket;
    }
    
    // hash function to evaluate index at secondary array which will hold boolean value of such key exists in set or not
    public int bucketItem(int key) {
        return key/bucketItem;
    }

    /** Initialize your data structure here. */
    public MyHashSet() {
        // initialized primary and secondary array sizes and array
        bucket = 1000;
        bucketItem = 1000;
        set = new boolean[bucket][];
    }
    
    // Identification of index constant and adding constant time - O(1)
    public void add(int key) {
        // identify index by double hashing.
        int hash1 = this.bucket(key);
        int hash2 = this.bucketItem(key);
        // if there is no array present at address specified in primary array index create a new array
        if(set[hash1]==null) {
            // to handle case we recieve 1000000 value, it will be 1000th index at 0th position array, hence a check done and created array of size 1001   
            if(hash1==0) {
                set[hash1] = new boolean[bucketItem+1];
            } else {
                // else create array of size 1000
                set[hash1] = new boolean[bucketItem];
            }
        }
        // specifies this integer is not present in set
        set[hash1][hash2] = true;
    }
    
    // Identification of index constant and removal at constant time - O(1)
    public void remove(int key) {
        // Identify index by double hashing
        int hash1 = this.bucket(key);
        int hash2 = this.bucketItem(key);
        // if no array present, there is no value to remove
        if(set[hash1]==null) return;
        // otherwise assign false to index value specifying this value is no longer present in set
        set[hash1][hash2] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        // identifying index using double hashing
        int hash1 = this.bucket(key);
        int hash2 = this.bucketItem(key);
        // if no array present, cant find value at that index, returning false
        if(set[hash1]==null) return false;
        // else return whatever value is present at that position
        return set[hash1][hash2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
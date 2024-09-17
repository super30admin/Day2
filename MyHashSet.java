// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach: Create a 2D array, intialize it with only primary array size to utilize space, Compute two hash functions for primary and secondary array index to avoid coliisions.
// For add operation, if primary element is null then create a secondary array at primary index and enter true for the given element.
// For remove operation, check if primary index is absent and if yes then return otherwise make element at primary and secondary index as false
// For contains operation, check if primary index is absent and if yes then return false otherwise return value of element at primary and secondary index 

class MyHashSet {
    // Creating a two dimensional array for primary and secondary storage
    private boolean[][] storage;
    private int primaryArraySize;
    private int secondaryArraySize;
    public MyHashSet() {
        primaryArraySize = 1000;
        secondaryArraySize = 1000;
        // Creating array with only primary storage for space utilization
        storage = new boolean[primaryArraySize][];        
    }
    public int primaryHash(int key) {
        // Using mod function to ensure the primary array indices are unique and primary collision is avoided
        return key % primaryArraySize;
    }
    public int secondaryHash(int key) {
        // Using div to make sure secondary indices are unique and nested collison is avoided
        return key / secondaryArraySize;
    }
    public void add(int key) {
      int primaryHashValue = primaryHash(key);
      int secondaryHashValue = secondaryHash(key);
      // Primary Index does not  have any value hence creating a secondary array at primary index
        if(storage[primaryHashValue]==null) {
            // To ensure in case of 1000000 value we have array capacity with last index as 1000 instead of 999
            if(primaryHashValue == 0) {
                storage[primaryHashValue] = new boolean[secondaryArraySize+1];
            } else {
                storage[primaryHashValue] = new boolean[secondaryArraySize];
            }            
        }
        storage[primaryHashValue][secondaryHashValue] = true;
    }

    public void remove(int key) {
        int primaryHashValue = primaryHash(key);
        int secondaryHashValue = secondaryHash(key);
        if(storage[primaryHashValue]==null) return;
        storage[primaryHashValue][secondaryHashValue]= false;        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int primaryHashValue = primaryHash(key);
        int secondaryHashValue = secondaryHash(key);
        if(storage[primaryHashValue]==null) return false;
        return storage[primaryHashValue][secondaryHashValue];        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

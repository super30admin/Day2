package Day1;

class MyHashSet {
	  
    // Time Complexity: O(1)
    // All operations involved array(1-d/2-d) insertion, deletion or retrieval which has O(1) complexity.
    
    // Space Complexity: O(n) 
   //  Worst case scenario when all 1000000 elements are initialized in the 2-d boolean storage array.
    
    // Did this code successfully run on Leetcode : No
    // Any problem you faced while coding this : No
    
    int buckets;
    int bucketSize;
    boolean[][] storage;

    /** Initialize your data structure here. */
    // Initialized a 2d array of colsize = underroot of permissible Max value, i.e. 1000000.
    // rowsize declared in a variable but yet not initialized in array
    // rowsize will be initialized when a value has to be inserted on that specific index.
    public MyHashSet() {
        buckets =  1000;
        bucketSize = 1000;
        storage = new boolean[buckets][];
    }
    
    // get hashcodes of the new key using both the hashfunctions which will yield two different values
    // check if a value has been inserted at hashValue1 index in 'storage' array
    // if yes => array rowsize has also been initialized already => just insert boolean value of 'true' on array element indexed at (hashvalue1 , hashvalue2).
    // if no => initialize rowSize array on col index = hashValue1 => then insert boolean value of 'true' on array element indexed at (hashvalue1 , hashvalue2). 
    public void add(int key) {
        int hashValue1 = hashFunct1(key);
        int hashValue2 = hashFunct2(key);
        if (storage[hashValue1] == null) {
            storage[hashValue1] = new boolean[bucketSize];
        }
        storage[hashValue1][hashValue2] = true;
    }
    
    // get hashcodes of the new key using both the hashfunctions which will yield two different values
    // check if a value has been inserted at hashValue1 index in 'storage' array
    //     if true => check if array element indexed at (hashvalue1 , hashvalue2) is true
    //         if true => set the array value to false.
    public void remove(int key) {
        int hashValue1 = hashFunct1(key);
        int hashValue2 = hashFunct2(key);
        
        if (storage[hashValue1] != null && storage[hashValue1][hashValue2] == true) {
            storage[hashValue1][hashValue2] = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    // get hashcodes of the new key using both the hashfunctions which will yield two different values
    // check if a value has been inserted at hashValue1 index in 'storage' array
    //     if true => check if array element indexed at (hashvalue1 , hashvalue2) is true
    //         if true => return true since boolean value of true implies that an element is present at the array indexed corresponding to hash functions for key. 
    public boolean contains(int key) {
        int hashValue1 = hashFunct1(key);
        int hashValue2 = hashFunct2(key);
        if (storage[hashValue1] != null && storage[hashValue1][hashValue2] == true) {
            return true;
        } 
        return false;
    }
    
    // first hashcode function to return hashcode for a numeric input
    private int hashFunct1 (int val) {
        return Integer.hashCode(val) % buckets;
    }
  
    // first hashcode function to return hashcode for a numeric input
    private int hashFunct2 (int val) {
        return Integer.hashCode(val) / buckets;
    }
    
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
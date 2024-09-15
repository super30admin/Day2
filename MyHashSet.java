/**
Time Complexity :
 - add(): O(1)
 - remove(): O(1)
 - contains(): O(1)
Space Complexity : O(n square)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/

class MyHashSet {
    private int bucket = 1000;
    private int bucketItem = 1000;
    
    /**
    This hash function computes the row index
    */
    public int hashFunc1(int key) {
        return key % bucket;
    }
    
    /**
    This hash function computes the index of the array 
    inside an array.
    */
    public int hashFunc2(int key) {
        return key / bucketItem;
    }
    
    private boolean hashSet[][];

    /** Initialize your data structure here. */
    public MyHashSet() {
        /**
        Only the first dimension is initialized.
        The second dimension will be initialized as necessary.
        */
        hashSet = new boolean[bucket][];
    }
    
    public void add(int key) {
        /**
        Approach:
        - First compute the indexes to which the new element should be added.
        - Check if the hashSet[index1] is null. If so, initialize it.
        - Then add the item at the computed indexes.
        */
        int index1 = hashFunc1(key);
        int index2 = hashFunc2(key);
        
        if (hashSet[index1] == null) {
            hashSet[index1] = new boolean[bucketItem];
        }
        hashSet[index1][index2] = true;
    }
    
    public void remove(int key) {
        /**
        Approach:
        - First compute the indexes from which the new element should be removed.
        - Check if the hashSet[index1] is not null. If so, assign a false.
        */
        int index1 = hashFunc1(key);
        int index2 = hashFunc2(key);
        
        if (hashSet[index1] != null) {
            hashSet[index1][index2] = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        /**
        Approach:
        - First compute the indexes for which the element should be verified.
        - Check if the hashSet[index1] is not null. If so, return true else, return false.
        */
        int index1 = hashFunc1(key);
        int index2 = hashFunc2(key);
        
        if (hashSet[index1] != null) {
            return hashSet[index1][index2];
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

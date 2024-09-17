// Time Complexity : O(1) Tradeoff is 
// Space Complexity : O(n) n is maximum number possible (bounded)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I initially tried implementing this with double hashing but led to couple issues.
// Will visit that approach again. One thing that concerns me about the below approach is space complexity. The question mentions
// that maximum operations that will be performed are 10000 of which even if all are push, maximum space we would need is 
// 10000 and not 1 million.

class HashSetDesign {

    boolean[][] hashTable;
    /** Initialize your data structure here. */
    public MyHashSet() {
        hashTable = new boolean[1000][];
    }
    
    public void add(int key) {
        if(hashTable[hashBucketNum(key)] == null) {
            hashTable[hashBucketNum(key)] = new boolean[1000];
        }
        
        hashTable[hashBucketNum(key)][hashBucketItemNum(key)] = true;
    }
    
    public void remove(int key) {
        if(hashTable[hashBucketNum(key)] == null) {
            return;
        }
        
        hashTable[hashBucketNum(key)][hashBucketItemNum(key)] = false;
    }
    
    private int hashBucketNum(int key) {
        return key%1000;
    }
    
    private int hashBucketItemNum(int key) {
        return key/1000;
    }
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return hashTable[hashBucketNum(key)] != null &&
            hashTable[hashBucketNum(key)][hashBucketItemNum(key)] == true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
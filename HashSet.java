// Time Complexity : O(1) for all operations
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashSet {
    
    private int bucket =1000;
    private int bucketItem = 1000;
    
    private int hashFunc(int key){
        return key % bucket;
    }
    
    private int hashFunc2(int key){
        return key / bucketItem;
    }

    private boolean[][] hashSet = null;
    /** Initialize your data structure here. */
    public MyHashSet() {
        hashSet = new boolean[bucket][];
    }
    
    public void add(int key) {
        int index1 = hashFunc(key);
        int index2 = hashFunc2(key);
        
        if(hashSet[index1] == null){
            hashSet[index1] = new boolean[bucketItem];
        }
        hashSet[index1][index2] = true;
    }
    
    public void remove(int key) {
        int index1 = hashFunc(key);
        int index2 = hashFunc2(key);
        if(hashSet[index1] != null){
            hashSet[index1][index2] = false;
        }
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index1 = hashFunc(key);
        int index2 = hashFunc2(key);
        return hashSet[index1] != null && hashSet[index1][index2];
    }
}
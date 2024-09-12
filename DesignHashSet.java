/** Leet Code Problem 705
    Design Hash Set
    Language Used : Java
    Link: https://leetcode.com/problems/design-hashset/
    Runtime: 10 ms, faster than 90.04% of Java online submissions for Design HashSet.
    Memory Usage: 47.3 MB, less than 36.53% of Java online submissions for Design HashSet.

Explaination:

 Data Structures Used : 1 array for the main and if duplicate hash entries come one more array
 bucket for the first one
 bucketItem for second one
 Suppose an element comes in 10, bucket checks if its there in the hash. Imagine hash function is % 1000. 
 Then 10 would be in 10th bucket
 Now imagine a new num comes 1010, how will it be stored?
 then we take the bucketItem and 1010/1000 is the space for 1010 in the second array and
 10/1000 is the space for 10 in second array 

 */

class MyHashSet {
    private boolean [][] HashSet;
    private int bucket;
    private int bucketItem;

    /** Initialize your data structure here. */
    public MyHashSet() {
        bucket = 1001;
        bucketItem = 1001;
        HashSet = new boolean [bucket][];
    }
    private int bucket(int key){
        return key % bucket;
    }
    private int bucketItem(int key){
        return key / bucketItem;
    }
    
    public void add(int key) {
         int buck = bucket(key);
        int buckItem = bucketItem(key);
        if(HashSet[buck]==null){
            HashSet[buck] = new boolean [bucketItem];
        }
        HashSet[buck][buckItem] = true;
    }
    
    public void remove(int key) {
        int buck = bucket(key);
        int buckItem = bucketItem(key);
        if(HashSet[buck]==null)
            return;
        HashSet[buck][buckItem]=false;
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int buck = bucket(key);
        int buckItem = bucketItem(key);
        if(HashSet[buck]==null)
            return false;
        return HashSet[buck][buckItem];
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
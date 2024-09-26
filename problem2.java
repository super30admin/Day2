// Time Complexity : O(1)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyHashSet {
    
        private int outerArraySize;
        private int innerArraySize;
        private boolean[][] hashSetStorage;

    /** Initialize your data structure here. */
    public MyHashSet() {
        outerArraySize = 1000;
        innerArraySize = 1000;
        hashSetStorage = new boolean[outerArraySize][];
    }
    
    private int outerHash(int key) {
        return key%outerArraySize;
    }
    
    private int innerHash(int key) {
        return key/innerArraySize;
    }
    
    public void add(int key) {
        if(hashSetStorage[outerHash(key)]==null) {      //if outer array hash index is null, add inner array
            if(outerHash(key)==0)                       //handle ArrayIndexOutOfBound at inner array index 1000
                hashSetStorage[outerHash(key)] = new boolean[innerArraySize+1];
            else
                hashSetStorage[outerHash(key)] = new boolean[innerArraySize];
        };
        hashSetStorage[outerHash(key)][innerHash(key)] = true;
    }
    
    public void remove(int key) {
        if(hashSetStorage[outerHash(key)]==null) return;  //check corresponding hash value index in outer array is null
         hashSetStorage[outerHash(key)][innerHash(key)] = false; //make the corresponding value false.
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(hashSetStorage[outerHash(key)]==null) return false; //check corresponding hash value index in outer array is null
        return hashSetStorage[outerHash(key)][innerHash(key)]; //get the value from the inner array and return 
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
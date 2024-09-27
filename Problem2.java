// Time Complexity : O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashSet {
    boolean hSet [][];
    //row size of 2d array
    int buckets;
    //column size of 2d array
    int bucketItems;
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = 10001;
        bucketItems = 10000;
        //initializing the 2d array with only rows
        hSet = new boolean [buckets][];
    }
    //hash function 1
    public int hash1 (int key){
        return key % 10;
    }
    //hash function 2
    public int hash2 (int key){
        return key / 10;
    }
    
    public void add(int key) {
        //get the indexes for the key using the above 2 hash functions
        int index1 = hash1(key);
        int index2 = hash2(key);
        //add column to an row index if not exists
        if(hSet[index1] == null){
            hSet[index1] = new boolean[bucketItems];
        }
        //set the cell as true indicating the key is stored
        hSet[index1][index2] = true;
    }
    
    public void remove(int key) {
         //get the indexes for the key using the above 2 hash functions
        int index1 = hash1(key);
        int index2 = hash2(key);
        //return if the row index dosenot have any columns
        if(hSet[index1] == null) return;
        //make the cell false indicating the key is removed
        hSet[index1][index2] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
         //get the indexes for the key using the above 2 hash functions
        int index1 = hash1(key);
        int index2 = hash2(key);
        //return false if the row index is null or the cell is false indicating the key does not exists
        if(hSet[index1] == null || hSet[index1][index2] == false)  return false;
        //else return true indicating the key exists
        return true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
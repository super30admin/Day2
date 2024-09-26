// Time Complexity : O(1) for add(), remove(), contains()
// Space Complexity : O(10^6)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
//intialize set datastructure, boolean[1000][1001]
//calculate hash1 and hash2 for key, key%1000, key/1000
//place according to hash1 and hash2, set[hash1][hash2]

class MyHashSet {
    static int numBuckets=1000, bucketSize=1000+1; 
    boolean[][] set;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        //intialize set datastructure, boolean[][]
         
        set = new boolean[numBuckets][];
    }
    
    private static int getHash1(int key){
        return key%numBuckets;
    }
    
    private static int getHash2(int key){
        return key/bucketSize;
    }
    
    //O(1)
    public void add(int key) {
        //calculate hash1 and hash2 for key 
        int hash1 = getHash1(key);
        int hash2 = getHash2(key);
        
        //check if bucket is empty, initialize, set value acc to hash2
        if(set[hash1]==null){
            set[hash1] = new boolean[bucketSize];
        }
        
        set[hash1][hash2] = true;
    }
    
    //O(1)
    public void remove(int key) {
        //calculate hash1 and hash2 for key 
        int hash1 = getHash1(key);
        int hash2 = getHash2(key);
        
        //check if bucket is empty, return 
        if(set[hash1]==null)
            return;
        
        //set position in bucket acc to hash2
        set[hash1][hash2] = false;
    }
    
    /** Returns true if this set contains the specified element */
    //O(1)
    public boolean contains(int key) {
        //calculate hash1 and hash2 for key 
        int hash1 = getHash1(key);
        int hash2 = getHash2(key);
        
        //check if bucket is empty, return false 
        if(set[hash1]==null)
            return false;
        
        //check position in bucket acc to hash2, return val
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
// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 

class MyHashSet {
    boolean[][] tmp;
    /** Initialize your data structure here. */
    public MyHashSet() {
            tmp = new boolean[10001][];
    }
    private int hashOne(int key) { // Hash for horizontal buckets
        return key%1000;
    }

    private int hashTwo(int key) { // Hash for vertical buckets to handle collisions
        return key/1000;
    }
    
    public void add(int key) {
        int hash1 = hashOne(key);
        int hash2 = hashTwo(key);
        if(tmp[hash1] == null) {
            tmp[hash1]= new boolean[1001]; 
        }
        tmp[hash1][hash2] = true;
    }
    
    public void remove(int key) {
        int hash1 = hashOne(key);
        int hash2 = hashTwo(key);
        if(tmp[hash1] == null) {
              return;
          }
        else{
            tmp[hash1][hash2] = false;
        }
    }
 
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash1 = hashOne(key);
        int hash2 = hashTwo(key);
          if(tmp[hash1] == null) {
              return false;
          }
        else{
            return tmp[hash1][hash2];
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

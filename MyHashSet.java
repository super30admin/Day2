// Time Complexity : O(1)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
class MyHashSet {
    
    boolean[][] bucket;
 
    /** Initialize your data structure here. */
    public MyHashSet() {
        bucket = new boolean[1000][];
        
    }
    
    private int hashOne(int key) {
        return key%1000;
    }
    
    private int hashTwo(int key) {
        return key/1000;
    }
    
    
    public void add(int key) {
        int hash1 = hashOne(key);
        int hash2 = hashTwo(key);
      
        
        if(bucket[hash1] == null) {
            if(hash1 == 0) {
                 bucket[hash1]= new boolean[1001];
            }
            else {
                bucket[hash1]= new boolean[1000]; 
            }
        }
        bucket[hash1][hash2] = true;
        
    }
    
    public void remove(int key) {
        int hash1 = hashOne(key);
        int hash2 = hashTwo(key);
        if(bucket[hash1] == null) {
              return;
          }
        else{
            bucket[hash1][hash2] = false;
        }
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash1 = hashOne(key);
        int hash2 = hashTwo(key);
          if(bucket[hash1] == null) {
              return false;
          }
        else{
            return bucket[hash1][hash2];
        }
        
        
    }
}
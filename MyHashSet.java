// Time Complexity : O(1)
// Space Complexity : O(N*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class MyHashSet {

    boolean[][] bucket; 
    int b1size;
    int b2size;
    /** Initialize your data structure here. */
    public MyHashSet() {
        b1size = 999;
        b2size = 999;
        bucket = new boolean[b1size][];
       
    }
    
    public void add(int key) {
        
        int index1 = key % b1size;
        int index2 = key / b2size;
        
        if(bucket[index1] == null)
            bucket[index1] = new boolean[b2size];
        
        bucket[index1][index2] = true;
        
    }
    
    public void remove(int key) {
        int index1 = key % b1size;
        int index2 = key / b2size;
        
        if(bucket[index1] == null)
           return;
        
        bucket[index1][index2] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        
        int index1 = key % b1size;
        int index2 = key / b2size;
        
        if(bucket[index1] == null)
           return false;
        
        return bucket[index1][index2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
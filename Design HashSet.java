// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : No

class MyHashSet {

    /** Initialize your data structure here. */
   
   int bucket=1000;
   int bucketList=1001;
    
    boolean arr[][]=new boolean[bucket][];
    
    public MyHashSet() {
        
    }
    private int hash1(int key)
    {
        return key%1000;
    }
    private int hash2(int key)
    {
        return key/1000;
    }
    
    public void add(int key) {
        int index1=hash1(key);
        int index2=hash2(key);
        
        if(arr[index1]==null)
        {
            arr[index1]=new boolean[bucketList];
        }
        arr[index1][index2]=true;
           
    }
    
    public void remove(int key) {
        int index1=hash1(key);
        int index2=hash2(key);
        if(arr[index1]==null) return;
        arr[index1][index2]=false;
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        
        int index1=hash1(key);
        int index2=hash2(key);
        
        if(arr[index1]==null)
        {
            return false;
        }
        return arr[index1][index2];
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

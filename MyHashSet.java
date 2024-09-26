// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : How do I determine Space Complexity for this or in general? I don't know if my answer for it is correct.
class MyHashSet {
    boolean[][] storage;
    int bucket ,bucketItem;
    /** Initialize your data structure here. */
    public MyHashSet() {
        bucket = 1001;
        bucketItem = 1000;
        storage = new boolean[bucket][];
    }
    
    private int hashOne(int key)
    {
        return key%bucket;
    }
    private int hashTwo(int key)
    {
        return key/bucket;
    }
    
    public void add(int key) {
        int pos1 = hashOne(key);
        int pos2 = hashTwo(key);
        if(storage[pos1]==null)
        {
            storage[pos1] = new boolean[bucketItem];
            
        }
        storage[pos1][pos2] = true;
        
        
    }
    
    public void remove(int key) {
        
        int pos1 = hashOne(key);
        int pos2 = hashTwo(key);
        if(storage[pos1] !=null)
        {
           storage[pos1][pos2] = false;
        }
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int pos1 = hashOne(key);
        int pos2 = hashTwo(key);
        if(storage[pos1]!=null)
        {
            return storage[pos1][pos2];
        }
        return false;
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
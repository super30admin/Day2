// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MyHashSet {
    private int buckets = 1000;
    private int itemsPerBucket = 1000;
    private boolean[][] table;
    
    public MyHashSet() {
        table = new boolean[buckets][];
        
    }
    
    public int firstHash(int key){
        return key%buckets;
    }
    public int secondHash(int key){
        return key/buckets;
    }
    
    public void add(int key) {
        int bucket = firstHash(key);
        int bucketItem = secondHash(key);
        
        if( table[bucket] == null)
        {
            table[bucket] = new boolean[itemsPerBucket];
            
        }
        table[bucket][bucketItem]=true;
        
    }
    
    public void remove(int key) {
        int bucket = firstHash(key);
        int bucketItem = secondHash(key);
        if(table[bucket] != null){
          table[bucket][bucketItem]=false;
        }
        
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = firstHash(key);
        int bucketItem = secondHash(key);
        if(table[bucket] !=null){
            
          return table[bucket][bucketItem];
        }
        
        return false;
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */


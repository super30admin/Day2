Time Complexity-Search-O(1)
Space Complexity-O(n)
class MyHashSet {
    int buckets=1000;
    int bucketItems=1000;
    boolean[][] storage=new boolean[buckets][];
    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    private int bucket(int key)
    {
        return key%1000;
    }
    
    private int bucketItem(int key)
    {
        return key/1000;
    }
    
    public void add(int key) {
        int bucket=bucket(key);
        int bucketItem=bucketItem(key);
        if(storage[bucket]==null)
                storage[bucket]=new boolean[bucketItems];
        storage[bucket][bucketItem]=true;
    }
    
    public void remove(int key) {
        int bucket=bucket(key);
        int bucketItem=bucketItem(key);
        if(storage[bucket]!=null)
            storage[bucket][bucketItem]=false;
            
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
         if(storage[bucket(key)]!=null)
            return storage[bucket(key)][bucketItem(key)];
         else
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


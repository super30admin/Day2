//Time complexity: O(1)
//Space Complexity: O(n)
// 705
class MyHashSet {
int bucket;
    int bucketitems;
    boolean[][] storage;
    /** Initialize your data structure here. */
    public MyHashSet() {
    bucket=1000;
    bucketitems=1000;
    storage=new boolean[bucket][];
        
    
    }
    
    public int bucket(int key)
    {
        return key%bucket;
    }
    public int bucketitems(int key)
    {
        return key/bucketitems;
    }
    
    public void add(int key) {
    
        int h1=bucket(key);
        int h2=bucketitems(key);
       if(storage[h1]==null)
       {
           if(h1==0)
           {
               storage[h1]=new boolean[bucketitems+1];
           }
           else
           {
               storage[h1]=new boolean[bucketitems];
           }
       }
        storage[h1][h2]=true;
    }
    
    public void remove(int key) {
         int h1=bucket(key);
        int h2=bucketitems(key);
        if(storage[h1]==null)
           return;
        storage[h1][h2]=false;
      
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int h1=bucket(key);
        int h2=bucketitems(key);
        if(storage[h1]==null)
            return false;
        return storage[h1][h2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
class MyHashSet {
    
    private boolean[][] storage;
        int bucket = 1000;
        int bucketList=1000;
    /** Initialize your data structure here. */
    public MyHashSet() {
        storage=new boolean[bucket][];
    }
    public int bucket(int key){
        return key%bucket;
    }
    public int bucketList(int key){
        return key/bucketList;
    }

    public void add(int key) {
     if(storage[bucket(key)] == null){
         if(bucket(key)==0)
             storage[bucket(key)] = new boolean [bucketList+1];
         else
            storage[bucket(key)] = new boolean [bucketList];    
     }
      storage[bucket(key)][bucketList(key)] = true;
    }

    public void remove(int key) {
        if (storage[bucket(key)]== null){
            return;
        }
        storage[bucket(key)][bucketList(key)]= false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if (storage[bucket(key)]== null)
            return false;
       return storage[bucket(key)][bucketList(key)];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */  
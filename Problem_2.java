class MyHashSet {
  
    private int bucket = 1000;
    private int bucketItem = 1000;
     boolean[][] hset;
    private int hashfunc1(int key){
      return key % bucket; // to get which row will this bucket be
    }
  
    private int hashfunc2(int key){
      return key / bucketItem; // get where where exactly on that row should the position be
    }
    /** Initialize your data structure here. */
    public MyHashSet() {
       hset = new boolean[bucket][]; //get the second array size only if it is required : space conservation if possible
    }
    
    public void add(int key) {
        int index1 = hashfunc1(key);
        int index2 = hashfunc2(key);
      if(hset[index1] == null){
        hset[index1] = new boolean[bucketItem];
      }
      hset[index1][index2] = true;
      
    }
    
    public void remove(int key) {
        int index1 = hashfunc1(key);
        int index2 = hashfunc2(key);
      
      if(hset[index1] != null){ // to avoid null pointer exception
        hset[index1][index2] = false;
      }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index1 = hashfunc1(key);
        int index2 = hashfunc2(key);
        
        if(hset[index1] != null){
          return hset[index1][index2];
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

class MyHashSet {

    /** Initialize your data structure here. */
    int size = 10000;
     boolean[][] bucket;
    public MyHashSet() {
      bucket = new boolean[size][];
    }
    
    int hashCode(int key){
        return key%size;
    }
    
    public void add(int key) {
        int index = hashCode(key);
        if(bucket[index]==null)
            bucket[index] = new boolean[size+1];
        bucket[index][key/size] = true;
        
    }
    
    public void remove(int key) {
        int index = hashCode(key);
         if(bucket[index]==null)
             return;
         bucket[index][key/size] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
       int index = hashCode(key);
        if(bucket[index]==null)
            return false;
        else
            if(bucket[index][key/size])
                return true;
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
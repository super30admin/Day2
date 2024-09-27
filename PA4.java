class MyHashSet {

    /** Initialize your data structure here. */
    
    boolean[][] arr ;
    public MyHashSet() {
       arr = new boolean[1000][];
    }
    public int getBucketId(int key){
        return key%1000;
    }
      public int getItemId(int key){
        return key/1001;
    }
    
    public void add(int key) {
        if(arr[getBucketId(key)]==null){
            arr[getBucketId(key)] = new boolean[1000];
        }
        arr[getBucketId(key)][getItemId(key)] = true;
    }
    
    public void remove(int key) {
        if(arr[getBucketId(key)] != null){
            arr[getBucketId(key)][getItemId(key)] = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
         if(arr[getBucketId(key)] != null){
           return arr[getBucketId(key)][getItemId(key)];
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
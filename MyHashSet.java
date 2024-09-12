class MyHashSet {
    int bucket = 1000;     //primary
    int bucketItem = 1000;  //nested
    boolean  myHashSet[][];

    /** Initialize your data structure here. */
    public MyHashSet() {
      myHashSet = new boolean[bucket][];  //Initialize with key
    }
    
    private int bucketIndex(int key){
        return key%bucket;
    }
    
    private int bucketItemIndex(int key){
        return key/bucketItem;
    }
    
    public void add(int key) {
       int index1 = bucketIndex(key);
        int index2 = bucketItemIndex(key); 
        if(myHashSet[index1] == null){
            myHashSet[index1] = new boolean [bucket];
        }
        myHashSet[index1][index2] = true;
    }
    
    public void remove(int key) {
       int index1 = bucketIndex(key);
        int index2 = bucketItemIndex(key); 
        if(myHashSet[index1] != null ){
            myHashSet[index1][index2] = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index1 = bucketIndex(key);
        int index2 = bucketItemIndex(key);
        
        return myHashSet[index1]!=null && myHashSet[index1][index2]; 
    }
}

//Time complexity O(1) -- double hashing technique 
//Space complexity O(1) -- constant space used

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
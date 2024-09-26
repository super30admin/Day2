class MyHashSet {

    
    int bucket = 1000;
    int bucketItem = 1000;
    boolean[][] HashSet;
    /** Initialize your data structure here. */
    public MyHashSet() {
        
        HashSet = new boolean[bucket][bucketItem];
        
    }
    
    public int getIndex1(int key){
        return key % bucket;
    }
    public int getIndex2(int key){
        return key / bucketItem;
    }
    public void add(int key) {
        int index1 = getIndex1(key);
        int index2 = getIndex2(key);
    
        HashSet[index1][index2] = true;
    }
    
    public void remove(int key) {
       int index1 = getIndex1(key);
       int index2 = getIndex2(key);
    
       HashSet[index1][index2] = false; 
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index1 = getIndex1(key);
        int index2 = getIndex2(key);
            if(HashSet[index1][index2] == true)
                return true;
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

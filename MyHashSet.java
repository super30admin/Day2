class MyHashSet {
    
    int bucket = 1000;
    int bucketItem = 1000;
    
    boolean[][] hashset; 
    
    private int bucketIndex(int key){
        return key % bucket;
    }
    
    private int bucketItemIndex(int key){
        return key / bucketItem;
    }
    
    /** Initialize your data structure here. */
    public MyHashSet() {        
        hashset = new boolean[bucket][];        
    }
    
    public void add(int key) {
        int index1 = bucketIndex(key);
        int index2 = bucketItemIndex(key);
        
        if(hashset[index1] == null){
            hashset[index1] = new boolean[bucketItem];            
        }
        
        hashset[index1][index2] = true;
    }
    
    public boolean contains(int key){
        int index1 = bucketIndex(key);
        int index2 = bucketItemIndex(key);
        
        return (hashset[index1] != null) && (hashset[index1][index2]);
    }
    
    public void remove(int key) {
        int index1 = bucketIndex(key);
        int index2 = bucketItemIndex(key);
        
        if(hashset[index1] != null){
            hashset[index1][index2] = false;
        }
    }
}


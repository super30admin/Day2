   /*Algorithm:
       1. Create 2D boolean array of size [parent][] initially, while adding a key using primaryHash and secondaryHash function get the position. Create a new array for the first time at position resulted from primaryHash function of size child. Set hashArr[bucket][bucketItem] as true
       2. While removing an element go the respective position in the 2D array and set the element as false.
       3. While checking for contains in hashArr, return for whatever is there at hashArray[bucket][bucketItem]
       
       Time Complexity:O(1)
       Space Complexity: O(n)
       
       Whether the program ran successfully on leetcode: Yes

    /** Initialize your data structure here. */
class MyHashSet {
 
     private int parent;
     private int child;
    
    private boolean[][] hashArr;
    public MyHashSet() {
        parent =1000;
        child = 1000;
        hashArr = new boolean[parent][];
        
    }
    
    private int primaryHash(int key){
        return key%parent;
        
    }
    private int secondaryHash(int key){
        return key/child;
    }
    
    public void add(int key) {
        int bucket = primaryHash(key);
        int bucketItem = secondaryHash(key);
        if(hashArr[bucket]==null){
            hashArr[bucket] = new boolean[child];
        }
        hashArr[bucket][bucketItem] = true;
        
    }
    
    public void remove(int key) {
        int bucket = primaryHash(key);
        int bucketItem = secondaryHash(key);
        if(hashArr[bucket]!=null){
            hashArr[bucket][bucketItem]=false;
        }
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = primaryHash(key);
        int bucketItem = secondaryHash(key);
        if(hashArr[bucket]!=null){
           return hashArr[bucket][bucketItem];
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
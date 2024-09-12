//Exercise_2 : Design HashSet--Double Hashing
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No


//First finding index of parent array by Modulo operation and then finding index of the child array with Division operation

class MyHashSetDoubleHashing {

    /** Initialize your data structure here. */
    private int bucketSize;
    private int bucketItemsSize;
    private boolean[][] storage;
    
    public MyHashSetDoubleHashing() {
       this.bucketSize = 1000;
       this.bucketItemsSize = 1001;//Because if key is passed 10^6, then on finding the bucket item index which is 10^6/1000 will return 1000 and there will be no index of 1000 as indexing is done from 0 to 999. Therefore initialise bucket item size with 1001, therefore index of 0-1000 can be stored  
       storage = new boolean[bucketSize][];//buckets item size is empty because in starting bot need ti initialize the bucket item , y to waste the memory . Secondly as it is a matrix menas object of object, it will be initialised with null
    }
    
    public void add(int key) {
        int bucketIndx     = bucketHahsing(key);
        int bucketItemIndx = bucketItemHahsing(key);
        
        if(storage[bucketIndx]==null){
            storage[bucketIndx] =  new boolean[bucketItemsSize];
        }
        
        storage[bucketIndx][bucketItemIndx] = true;
        
    }
    
    public void remove(int key) {
        
        int bucketIndx     = bucketHahsing(key);
        int bucketItemIndx = bucketItemHahsing(key);
        
        if(storage[bucketIndx]==null){
            return ;
        }
        
        storage[bucketIndx][bucketItemIndx] = false;
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        
        int bucketIndx     = bucketHahsing(key);
        int bucketItemIndx = bucketItemHahsing(key);
        
        if(storage[bucketIndx]==null){
            return false;
        }
        
        return  storage[bucketIndx][bucketItemIndx] ;
    }
    
    
    private int bucketHahsing(int key){
        
        return key%bucketSize;
    }
    
    private int bucketItemHahsing(int key){
        
        return key/bucketSize;//so that there will be a difference between parent index and the child index
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
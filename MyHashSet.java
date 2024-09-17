package Default;
//Time Complexity : O(1)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : Re-watched the lecture video to understand the hashset


//Your code here along with comments explaining your approach
class MyHashSet {

    /** Initialize your data structure here. */
    private boolean[][] storage;
    private int buckets;
    private int bucketItems;
    
    
    public MyHashSet() {
        
        buckets = 1001;
        bucketItems = 1001;
        storage = new boolean[buckets][];
        
        
    }
    
     private int bucket(int key){
        
        return key % 1000;
    }
    
    private int bucketItems(int key){
        
        return key / 1000;
    }
    
    
    public void add(int key) {
        
        int bucket = bucket(key);
        int bucketItem = bucketItems(key);
        
        if(storage[bucket] == null){
            
            storage[bucket] = new boolean [bucketItems];
        }
        
        storage[bucket][bucketItem] = true;
        
        
    }
    
    public void remove(int key) {
        
        int bucket = bucket(key);
        int bucketItem = bucketItems(key);
        
        if(storage[bucket] == null){
            
           return;
        }
        storage[bucket][bucketItem] = false;
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        
        int bucket = bucket(key);
        int bucketItem = bucketItems(key);
        
        if(storage[bucket] == null){
            
           return false;
        }
        
        return storage[bucket][bucketItem];
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

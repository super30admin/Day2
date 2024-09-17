// LC 705 : Design Hashset 

class MyHashSet {
    
    private int buckets;
    private int bucketItems;
    private boolean [][] storage;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1001;
        storage = new boolean [buckets][];  
        }
    
    private int hash1(int key) 
        {
            return key % buckets;
         }
        
    private int hash2(int key)
        {
            return key / buckets;
        }  

    
    public void add(int key) {
        
        int index1 = hash1(key);
        int index2 = hash2(key);
        
        if (storage[index1] == null)
            {
                storage [index1] = new boolean [bucketItems];
            }   
        storage [index1][index2] = true; 
        
    }
    
    public void remove(int key) {
        
        int index1 = hash1(key);
        int index2 = hash2(key);
        
        if (storage[index1] == null)
            {
                return;
            }   
        storage [index1][index2] = false;    
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains (int key) {
        
        int index1 = hash1(key);
        int index2 = hash2(key);
        
        if (storage[index1] == null)
            {
                return false;
            }   
         
        //return storage [index1] != null && storage [index1][index2];
        return storage [index1][index2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */



 // Complexity Analysis

 /*
Time Complexity: 
O(log K/N) where N is the number of all possible values and K is the number of predefined buckets, which is 769. 

Space Complexity: 
O(K+M) where K is the number of predefined buckets, and M is the number of unique values that have been inserted into the HashSet. 
 */
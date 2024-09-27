TC: O(n)
SC: O(n)

Leetcode webapplication is down 

Approach: Use double hashing to create the hashset. Use a boolean matrix to set and unset the presence of value.Once a new element is added, 
using the modulo function find the index in the boolean array.The second index in the boolean array corresponding to the first index, is found
by dividing the key with the bucketItem size.


class MyHashSet {
    int buckets = 1000
    int bucketItems = 1000;
    
    boolean [][] memory = new boolean[buckets][];
    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    public int bucket(int key){
        return key%bucket;
    }
    public int bucketindex(int key){
        return key/bucketItems;
    }
    public void add(int key) {
        int bucket = buckets(key);
        int bucketItem = bucketindex(key);
        if(memory[bucket] == null){
            memory[bucket]= new boolean[bucketItem];
        }
        memory[bucket][bucketItem]= true;
        
    }
    
    public void remove(int key) {
         int bucket = buckets(key);
        int bucketItem = bucketindex(key);
        if(memory[bucket][bucketItem]!= null){
            memory[bucket][bucketItem]= false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
         int bucket = buckets(key);
        int bucketItem = bucketindex(key);
        if(memory[bucket] != null){
            return memory[bucket][bucketItem];
        }else{
            return false;
        }
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

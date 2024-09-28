// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Used double hashing technique

// Two hash functions used in this problem are hash1 and hash2

//Initialized the primary array to 1000 and secondary array to 1000 because the we are the data range of 1000000

//Secondary array is initialized only if we get a hash code value of o from hash1 function

class MyHashSet {
    
    private boolean[][] storage;
    int buckets;
    int bucketLists;

    public MyHashSet() {
        buckets = 1000;
        bucketLists = 1000;
        storage = new boolean[buckets][];
        
    }
    
    private int hash1(int key) {
        return key % 1000;
    }
    
    private int hash2(int key) {
        return key / 1000;
    }
    
    public void add(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if(storage[hash1] == null) {
            if(hash1 == 0){
                storage[hash1] = new boolean[bucketLists + 1];
            }
                
            else {
                storage[hash1] = new boolean[bucketLists];
            }
        }    
        
        storage[hash1][hash2] = true;
        
    }
    
    public void remove(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if(storage[hash1] == null) return;
        storage[hash1][hash2] = false;
        
    }
    
    public boolean contains(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if(storage[hash1] == null) return false;
        return storage[hash1][hash2];
        
    }
}

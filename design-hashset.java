// Time Complexity - O(1) for add, contains, and remove
// Space Commplexity - O(N) where N here is 1000000
class MyHashSet {
    int buckets;
    int bucketItems;
    boolean[][] store;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        store = new boolean[buckets][];
    }
    
    private int hash1(int key) {
        return key % buckets;
    }
    
    private int hash2(int key) {
        return key / buckets;
    }
    
    public void add(int key) {
        int i = hash1(key);
        int j = hash2(key);
        
        if(store[i] == null) {
            store[i] = new boolean[bucketItems];
        }
        
        store[i][j] = true;
    }
    
    public void remove(int key) {
        int i = hash1(key);
        int j = hash2(key);
        if(store[i] == null) {
           return;
        }
        store[i][j] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int i = hash1(key);
        int j = hash2(key);
        if(store[i] == null) {
            return false;
        }
        else {
            return store[i][j];
        }
    }
}

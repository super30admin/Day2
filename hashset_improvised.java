// Time Complexity : O(1) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashSet {
    
    // Initialize boolean array, hash1 and hash2 size.
    private boolean [][] arr;
    private static int H1 = 1000;
    private static int H2 = 1000;

    public MyHashSet() {
        arr = new boolean [H1][];
    }
    
    private int getHash1(int key){
        return key % H1;
    }
    
    private int getHash2(int key){
        return key / H2;
    }
    
    // if the key is not present ass the key using hash functions
    public void add(int key) {
        if (!contains(key)){
            int hash1 = getHash1(key);
            if (arr[hash1] == null){
                arr[hash1] = new boolean[H1+1];
            }
            
            int hash2 = getHash2(key);
            arr[hash1][hash2] = true;
        }
        
    }
    
    public void remove(int key) {
        if (contains(key)){
            int hash1 = getHash1(key);
            int hash2 = getHash2(key);
            arr[hash1][hash2] = false;  
        }
    }
    
    // use hash functions to find whether the key exists or not
    public boolean contains(int key) {
        int hash1 = getHash1(key);
        if (arr[hash1] == null) {
            return false;
        }
        int hash2 = getHash2(key);
        return arr[hash1][hash2];
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
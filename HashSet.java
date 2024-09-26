// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashSet {

    // initializing array and integers
    // integers created based on constraint 10^6 which is split
    // into 10^3 and 10^3
    private boolean[][] myArray;
    private static int Hash1 = 1000;
    private static int Hash2 = 1000;
    
    public MyHashSet() {
        // we don't specify size of second array as it may or may not exist
        // if it exists, we can create that size on demand
        myArray = new boolean[Hash1][];
    }
    
    private int getHash1(int key) {
        return key % Hash1;
    }
    
    private int getHash2(int key) {
        return key / Hash2;
    }
    
    public void add(int key) {
        if (!contains(key)) {
            int hash1 = getHash1(key);
            if (myArray[hash1] == null) {
                // we check if the hash is 0 (10^6) array length, if yes 
                // then create new array with size + 1
                if (hash1 == 0) {
                    myArray[hash1] = new boolean[Hash1 + 1];
                }
                else {
                    myArray[hash1] = new boolean[Hash1];
                }
            }
            int hash2 = getHash2(key);
            myArray[hash1][hash2] = true;
        }
    }
    
    public void remove(int key) {
        if (contains(key)) {
            int hash1 = getHash1(key);
            int hash2 = getHash2(key);
            myArray[hash1][hash2] = false;
        }
    }
    
    public boolean contains(int key) {
        int hash1 = getHash1(key);
        
        if (myArray[hash1] == null) {
            return false;
        }
        else {
            int hash2 = getHash2(key);
            return myArray[hash1][hash2];
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
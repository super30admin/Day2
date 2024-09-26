// Time Complexity : Add, Remove, Contains should be O(1) since direct 2D array access. The calculation of Hashing fun should be constant too.
// Space Complexity : Space would be key_size so, here 10^6 + 1000 more. 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. I tried to reduce space 1000, by initializing hash_set[1001] and checking while adding condition, but code became slower.

class MyHashSet {
    // Taking 1001 to store the limit 10^6 value
    int size1 = 1001;
    int size2 = 1000;
    boolean[][] hash_set = new boolean[size1][];
    public MyHashSet() {
        hash_set = new boolean[size1][];
        // hash_set[1001] = new boolean[1]; I tried this but reduces the code running time from 87.5 % faster to 55%
    }

    // Hashing 1; div key
    public int getHash1(int key){
        return key/size1;
    }

    // Hashing 2; Mod key
    public int getHash2(int key){
        return key%size2;
    }

    // Checking hashes of the key and setting the boolean. Initializing array on demand
    public void add(int key) {
        int hash1 = getHash1(key);
        // Initializing arr if null
        if(hash_set[hash1]==null){
            hash_set[hash1] = new boolean[size2];
        }
        int hash2 = getHash2(key);
        // set the key exists
        hash_set[hash1][hash2] = true;
    }

    // Set key value to false if exists
    public void remove(int key) {
        if(contains(key)){
            int hash1 = getHash1(key);
            int hash2 = getHash2(key);
            hash_set[hash1][hash2] = false;
        }
    }

    // Check if the key exists
    public boolean contains(int key) {
        int hash1 = getHash1(key);
        if(hash_set[hash1]!=null){
            int hash2 = getHash2(key);
            return hash_set[hash1][hash2];
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
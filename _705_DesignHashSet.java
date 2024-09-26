import java.util.LinkedList;

// Time Complexity : o(1) for all operations
// Space Complexity : o(HASH_LEN1*HASH_LEN2+1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : Double hashing collision resolution strategy.
class MyHashSet {

    final private  int HASH_LEN1 = 1000;
    final private  int HASH_LEN2 = 1000;

    private  boolean[][] hashValMatrix;

    public MyHashSet() {
        hashValMatrix = new boolean[HASH_LEN1][];
    }

    public void add(int key) {

        if(contains(key)) return;

        int hash1 = getHash1(key);
        if(hashValMatrix[hash1] == null){
            if(hash1 == 0){
               hashValMatrix[hash1] = new boolean[HASH_LEN2+1];
            }
            else{
               hashValMatrix[hash1] = new boolean[HASH_LEN2];
            }
        }
        int hash2 = getHash2(key);
        hashValMatrix[hash1][hash2] = true;

    }

    public void remove(int key) {
        if(contains(key)){
            int hash1 = getHash1(key);
            int hash2 = getHash2(key);
            hashValMatrix[hash1][hash2] = false;
        }
    }

    public boolean contains(int key) {
        int hash1 = getHash1(key);
        int hash2 = getHash2(key);
        if(hashValMatrix[hash1] == null) return false;
        return hashValMatrix[hash1][hash2];
    }

    public int getHash1(int key){
        return key%HASH_LEN1;
    }
    public int getHash2(int key){
        return key/HASH_LEN2;
    }


}

// Time Complexity : O(1)  - Push O(1), Pop O(1)
// Space Complexity : O(N) - No of elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, straightforward

class MyHashSet {
    int bucket = 1001;

    boolean[][] hashset;
    /** Initialize your data structure here. */
    public MyHashSet() {
        hashset = new boolean[bucket][];
    }
    private int hash1(int key){
        return key % (bucket);
    }
    private int hash2(int key){
        return key / (bucket);
    }
    public void add(int key) {
        int index1 = hash1(key);
        int index2 = hash2(key);
        if(hashset[index1] == null){
            hashset[index1] = new boolean[bucket+1];
        }
        hashset[index1][index2] = true;
    }
    
    public void remove(int key) {
        int index1 = hash1(key);
        int index2 = hash2(key);
        if(hashset[index1] == null){
            return;
        }
        hashset[index1][index2] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index1 = hash1(key);
        int index2 = hash2(key);
        if(hashset[index1] == null){
            return false;
        }
        return hashset[index1][index2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
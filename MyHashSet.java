// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class MyHashSet {

    /** Initialize your data structure here. */
    boolean[][] arrHash;
    int bucket;
    int bucketItems;
    public MyHashSet() {
        bucket = 1001;
        bucketItems = 1000;
        arrHash = new boolean[bucket][];
        
    }
    private int bucket(int key) {
        return key % bucket;
    }

    private int bucketItems(int key) {
        return key / bucketItems;
    }
    
    public void add(int key) {
        int b = bucket(key);
        int bI = bucketItems(key);
        if (arrHash[b] == null) {
            arrHash[b] = new boolean[bucketItems];
            arrHash[b][bI] = true;
        } else {
            arrHash[b][bI] = true;
        }
    }
    
    public void remove(int key) {
       int b = bucket(key);
        int bI = bucketItems(key);
        if (arrHash[b] != null) {
            arrHash[b][bI] = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int b = bucket(key);
        int bI = bucketItems(key);
        if (arrHash[b] != null) {
            return arrHash[b][bI];
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
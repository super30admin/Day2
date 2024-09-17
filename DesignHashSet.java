package S30.Design_2;

// Time Complexity : Add: O(1), Remove: O(1), Contains: O(1)
// Space Complexity : O(n), n is maximum number of data range
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class DesignHashSet {

    int buckets;
    int bucketItems;
    boolean[][] set;
    /** Initialize your data structure here. */
    public DesignHashSet() {
        buckets = 1000;
        bucketItems = 1001;
        set = new boolean[buckets][];

    }

    private int hash1(int key){
        return key % 1000;
    }

    private int hash2(int key){
        return key / 1000;
    }

    //only add second array when key hashes to first index
    public void add(int key) {
        int idx1 = hash1(key);
        int idx2 = hash2(key);
        if(set[idx1] == null){
            set[idx1] = new boolean[bucketItems];
        }
        set[idx1][idx2] = true;

    }

    //set value to false to remove key from hashset
    public void remove(int key) {
        int idx1 = hash1(key);
        int idx2 = hash2(key);
        if(set[idx1] == null) return;
        set[idx1][idx2] = false;

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int idx1 = hash1(key);
        int idx2 = hash2(key);
        if(set[idx1] == null) return false;
        return set[idx1][idx2];

    }

}

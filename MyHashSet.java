/*
Time: Add O(1), Remove O(1), Contains O(1)
Space: O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None

*/

class MyHashSet {

    int buckets;
    int bucketItems;
    boolean[][] set;

    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1001;
        set = new boolean[buckets][];

    }

    public int hash1(int key) {
        return key % 1000;
    }

    public int hash2(int key) {
        return key / 1000;
    }

    public void add(int key) {
        int idx1 = hash1(key);
        int idx2 = hash2(key);

        if (set[idx1] == null) {
            set[idx1] = new boolean[bucketItems];
        }

        set[idx1][idx2] = true;

    }

    public void remove(int key) {
        int idx1 = hash1(key);
        int idx2 = hash2(key);

        if (set[idx1] == null) {
            return;
        }

        set[idx1][idx2] = false;
    }

    public boolean contains(int key) {
        int idx1 = hash1(key);
        int idx2 = hash2(key);

        if (set[idx1] == null) {
            return false;
        }

        return set[idx1][idx2];

    }
}

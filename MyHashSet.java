// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach
// Used Double Hashing as a solution

class MyHashSet {

    private boolean[][] set;
    private int buckets;
    private int bucketItems;

    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        set = new boolean[buckets][];
    }

    private int getBucket(int key) {
        return key % buckets;
    }

    private int getBucketItem(int key) {
        return key / bucketItems;
    }

    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);

        if (set[bucket] == null) {
            //  Edge case for the 10^6th element
            if (bucket == 0)
                set[bucket] = new boolean[bucketItems + 1];
            else
                set[bucket] = new boolean[bucketItems];
        }

        set[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);

        if (set[bucket] != null) {
            set[bucket][bucketItem] = false;
        }
    }

    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);

        if (set[bucket] == null)
            return false;

        return set[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
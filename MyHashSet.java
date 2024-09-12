
// Time Complexity : O(1)
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class MyHashSet {
    private boolean[][] storage;
    private int buckets;
    private int bucketItems;

    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }

    // double hashing
    private int bucket(int key) {
        return key % buckets;
    }

    private int bucketItem(int key) {
        return key / bucketItems;
    }

    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);

        if (storage[bucket] == null) {
            // we have 1001*1000... the first index will have 1001 araay
            if (bucket == 0) {
                storage[bucket] = new boolean[bucketItems + 1];
            } else {
                storage[bucket] = new boolean[bucketItems];
            }
        }
        // making it true to indicate that position has an key
        storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);

        // if the nested array isn't there, implies the key is not there
        if (storage[bucket] == null)
            return;
        // if key exists, make the key location false
        storage[bucket][bucketItem] = false;
    }

    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);

        // if there is no nested array
        if (storage[bucket] == null)
            return false;

        return storage[bucket][bucketItem];
    }
}

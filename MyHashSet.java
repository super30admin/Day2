// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
class MyHashSet {

    boolean[][] storage;
    int bucket;
    int bucketItems;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        storage = new boolean[1000][];
        bucket = 1000;
        bucketItems = 1000;
    }

    public int hashBucket(int key) {
        return key % bucket;
    }

    public int hashBucketItems(int key) {
        return key / bucketItems;
    }

    public void add(int key) {
        int bucketVal = hashBucket(key);
        int bucketItemVal = hashBucketItems(key);
        if (storage[bucketVal] == null) {
            if (bucketVal == 0) {
                //increasing space for 1000000th element
                storage[bucketVal] = new boolean[bucketItems + 1];
            } else {
                storage[bucketVal] = new boolean[bucketItems];
            }
        }
        storage[bucketVal][bucketItemVal] = true;
    }

    public void remove(int key) {
        int bucketVal = hashBucket(key);
        int bucketItemVal = hashBucketItems(key);
        if (storage[bucketVal] == null) {
            return;
        }
        storage[bucketVal][bucketItemVal] = false;
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int bucketVal = hashBucket(key);
        int bucketItemVal = hashBucketItems(key);
        if (storage[bucketVal] == null) {
            return false;
        }
        return storage[bucketVal][bucketItemVal];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj
 * = new MyHashSet(); obj.add(key); obj.remove(key); boolean param_3 =
 * obj.contains(key);
 */

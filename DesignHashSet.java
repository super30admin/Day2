// Time Complexity: 0(1), Space Complexity: O(N) where N is no of possible values
class MyHashSet {

    /** Initialize your data structure here. */
    int buckets;
    int bucketItems;
    boolean[][] hashset;

    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1001;
        hashset = new boolean[buckets][];
    }

    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (hashset[bucket] == null) {
            hashset[bucket] = new boolean[bucketItems];
        }
        hashset[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (hashset[bucket] == null)
            return;
        hashset[bucket][bucketItem] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (hashset[bucket] == null)
            return false;
        return hashset[bucket][bucketItem];
    }

    private int getBucket(int key) {
        return key % buckets;
    }

    private int getBucketItem(int key) {
        return key / bucketItems;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj
 * = new MyHashSet(); obj.add(key); obj.remove(key); boolean param_3 =
 * obj.contains(key);
 */

public class DesignHashSet {
    public static void main(String[] args) {
        MyHashSet obj = new MyHashSet();
        obj.add(10);
        obj.remove(10);
        boolean param_3 = obj.contains(10);
    }
}
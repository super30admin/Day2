// Time Complexity : O(1)
// Space Complexity : O(n); n = total no of elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyHashSet {
    boolean[][] hashSet;
    int buckets;
    int bucketList;
    /** Initialize your data structure here. */
    private int findBucket(int key) {
        return key % buckets;
    }
    private int findBucketList(int key) {
        return key / bucketList;
    }
    //Constructor
    public MyHashSet() {
        buckets = 5000;
        bucketList = 1001;
        hashSet = new boolean[buckets][];

    }

    //Time Complexity: O(1)
    public void add(int key) {
        int bucket = findBucket(key);
        int bucketItem = findBucketList(key);
        if (hashSet[bucket] == null) {
            hashSet[bucket] = new boolean[bucketList];
        }
        hashSet[bucket][bucketItem] = true;

    }

    //Time Complexity: O(1)
    public void remove(int key) {
        int bucket = findBucket(key);
        int bucketItem = findBucketList(key);
        if (hashSet[bucket] == null) return;

        hashSet[bucket][bucketItem] = false;

    }

    /** Returns true if this set contains the specified element */
    //Time Complexity: O(1)
    public boolean contains(int key) {
        int bucket = findBucket(key);
        int bucketItem = findBucketList(key);
        if (hashSet[bucket] == null) return false;

        return hashSet[bucket][bucketItem] ;
    }
}
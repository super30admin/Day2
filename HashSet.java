class MyHashSet {

    boolean buckets[][];

    int bucketSize;
    int bucketListSize;

    int getBucketIndex(int key)
    {
        return key % 1000;
    }

    int getBucketListIndex(int key) {
        return key / 1000;
    }

    /** Initialize your data structure here. */
    public MyHashSet() {
        bucketSize = 1000;
        bucketListSize = 1000;
        buckets = new boolean[bucketSize][];
    }

    public void add(int key) {
        int bucketIndex = getBucketIndex(key);
        int bucketListIndex = getBucketListIndex(key);

        if(buckets[bucketIndex] == null) {
            buckets[bucketIndex] = new boolean[bucketListSize];
        }
        buckets[bucketIndex][bucketListIndex] = true;
    }

    public void remove(int key) {
        int bucketIndex = getBucketIndex(key);
        int bucketListIndex = getBucketListIndex(key);

        if(buckets[bucketIndex] == null) {
            return;
        }
        buckets[bucketIndex][bucketListIndex] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketIndex = getBucketIndex(key);
        int bucketListIndex = getBucketListIndex(key);

        if(buckets[bucketIndex] == null) {
            return false;
        }
        return buckets[bucketIndex][bucketListIndex];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

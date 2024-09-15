// TIME: O(1)
// SPACE: O(n)
// SUCCESS on LeetCode

// using double hashing with a hash size of sqrt of the size of the input.
class MyHashSet {
    boolean[][] buckets;

    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = new boolean[1000][];
    }
    
    // index value for the main buckets
    private int getIndex(int key) {
        return key % 1000;
    }
    
    // index value for the sub buckets to avoid collisions
    private int getBucketIndex(int key) {
        return key / 1000;
    }
    
    public void add(int key) {
        int index = getIndex(key);
        if (buckets[index] == null) {
            boolean[] bucketList;
            if (index == 0) {
                bucketList = new boolean[1001];
            } else {
                bucketList = new boolean[1000];
            }
            int bucketIndex = getBucketIndex(key);
            bucketList[bucketIndex] = true;
            buckets[index] = bucketList;
            return;
        }
        int bucketIndex = getBucketIndex(key);
        buckets[index][bucketIndex] = true;
    }
    
    public void remove(int key) {
        int index = getIndex(key);
        int bucketIndex = getBucketIndex(key);
        if (buckets[index] == null) {
            return;
        }
        buckets[index][bucketIndex] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = getIndex(key);
        int bucketIndex = getBucketIndex(key);
        if (buckets[index] == null) {
            return false;
        }
        return buckets[index][bucketIndex];
    }
}


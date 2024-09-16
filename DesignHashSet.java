class MyHashSet {

    /** Initialize your data structure here. */
    int buckets = 1000;
    int bucketSize = 1000;
    boolean[][] arr;
    
    public MyHashSet() {
        arr = new boolean[buckets][];
    }

    public int getBucketsIndex(int key) {
        return key % 1000;
    }

    public int getBucketIndex(int key) {
        return key / 1000;
    }

    public void add(int key) {
        int bucketsIndex = getBucketsIndex(key);
        if (bucketsIndex == 0 && arr[bucketsIndex] == null) {
            arr[bucketsIndex] = new boolean[bucketSize + 1];
        }
        if (arr[bucketsIndex] == null) {
            arr[bucketsIndex] = new boolean[bucketSize];
        }
        arr[bucketsIndex][getBucketIndex(key)] = true;
    }
    
    public void remove(int key) {
        int bucketsIndex = getBucketsIndex(key);
        int bucketIndex = getBucketIndex(key);
        arr[bucketsIndex][getBucketIndex(key)] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketsIndex = getBucketsIndex(key);
        int bucketIndex = getBucketIndex(key);
        if (arr[bucketsIndex][getBucketIndex(key)]) {
            return true;
        } else {
            return false;
        }
    }
}
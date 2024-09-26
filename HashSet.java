class MyHashSet {

    /** Initialize your data structure here. */
    int buckets;
    int bucketItems;
    boolean[][] storage;

    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1001;
        storage = new boolean[buckets][];

    }

    private int bucket(int key) {
        return key % buckets;
    }

    private int bucketItems(int key) {
        return key / bucketItems;
    }

    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItems(key);
        if (storage[bucket] == null)
            storage[bucket] = new boolean[bucketItems];
        storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItems(key);
        if (storage[bucket] == null)
            return;
        storage[bucket][bucketItem] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItems(key);
        if (storage[bucket] == null)
            return false;
        return storage[bucket][bucketItem];

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj
 * = new MyHashSet(); obj.add(key); obj.remove(key); boolean param_3 =
 * obj.contains(key);
 */
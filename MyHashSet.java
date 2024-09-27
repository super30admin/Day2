class MyHashSet {

    /** Initialize your data structure here. */
    boolean[][] set;
    int buckets;
    int bucketItems;

    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        set = new boolean[buckets][];
    }

    private int bucket(int key) {
        return key % buckets;
    }

    private int bucketItem(int key) {
        return key / bucketItems;
    }

    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if (set[bucket] == null) {
            if (bucket == 0) {
                set[bucket] = new boolean[bucketItems + 1];
            } else {
                set[bucket] = new boolean[bucketItems];
            }
        }
        set[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if (set[bucket] == null)
            return;
        set[bucket][bucketItem] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if (set[bucket] == null)
            return false;
        return set[bucket][bucketItem];
    }
}
class MyHashSet {
    private boolean[][] storage;
    private int buckets;
    private int bucketItems;

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];
    }

    public int buckets(int key) {
        return key % buckets;
    }

    public int bucketItems(int key) {
        return key / bucketItems;
    }

    public void add(int key) {
        int bucket = buckets(key);
        int bucketItem = bucketItems(key);
        if (storage[bucket] == null) {
            if (bucket == 0) {
                storage[bucket] = new boolean[bucketItems + 1];
            } else {
                storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = buckets(key);
        int bucketItem = bucketItems(key);

        if (storage[bucket] == null)
            return;

        storage[bucket][bucketItem] = false;

    }

    public boolean contains(int key) {
        int bucket = buckets(key);
        int bucketItem = bucketItems(key);

        if (storage[bucket] == null)
            return false;

        return storage[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
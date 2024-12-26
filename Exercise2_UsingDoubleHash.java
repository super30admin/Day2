class MyHashMap2 {
    int buckets;
    int bucketItems;
    Integer[][][] storage;

    public MyHashMap2() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        storage = new Integer[this.buckets][][];
    }

    private int getBucketKey(int key) {
        return key % buckets;
    }

    private int getBucketItemsKey(int key) {
        return key / bucketItems;
    }

    public void put(int key, int value) {
        int bucketKey = getBucketKey(key);
        int bucketItemKey = getBucketItemsKey(key);
        if (storage[bucketKey] == null) {
            if (bucketKey == 0) {
                storage[bucketKey] = new Integer[this.bucketItems + 1][2];
            } else {
                storage[bucketKey] = new Integer[this.bucketItems][2];
            }
        }
        if (storage[bucketKey][bucketItemKey][0] != null && storage[bucketKey][bucketItemKey][0] == key) {
            storage[bucketKey][bucketItemKey][1] = value;
        } else {
            storage[bucketKey][bucketItemKey][0] = key;
            storage[bucketKey][bucketItemKey][1] = value;
        }
    }

    public int get(int key) {
        int bucketKey = getBucketKey(key);
        int bucketItemKey = getBucketItemsKey(key);
        if (storage[bucketKey] == null) {
            return -1;
        }
        if (storage[bucketKey][bucketItemKey][0] != null) {
            return storage[bucketKey][bucketItemKey][1];
        } else {
            return -1;
        }
    }

    public void remove(int key) {
        int bucketKey = getBucketKey(key);
        int bucketItemKey = getBucketItemsKey(key);
        if (storage[bucketKey] == null) {
            return;
        }
        if (storage[bucketKey][bucketItemKey][0] != null) {
            storage[bucketKey][bucketItemKey][0] = -1;
            storage[bucketKey][bucketItemKey][1] = -1;
        } else {
            return;
        }

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
class MyHashSet {

        int buckets = 1000;
        int bucket_items = 1000;
        boolean [][] hashset = new boolean[buckets][];
    /** Initialize your data structure here. */
    public MyHashSet() {
    }

    public int bucket(int key) {
        return key % buckets;
    }

    public int bucketItems(int key) {
        return key / bucket_items;
    }

    public void add(int key) {
        int primary = bucket(key);
        int secondary = bucketItems(key);
        if(hashset[primary] == null) {
            hashset[primary] = new boolean[bucket_items];
        }
        hashset[primary][secondary] = true;

    }

    public void remove(int key) {
        int primary = bucket(key);
        int secondary = bucketItems(key);
        if(hashset[primary] != null) {
            hashset[primary][secondary] = false;
        }


    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int primary = bucket(key);
        int secondary = bucketItems(key);
        return hashset[primary] != null && hashset[primary][secondary];


    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

// Time Complexity :0(1)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : on how to get started, discussed in class.


// Your code here along with comments explaining your approach


class MyHashSet {
    private boolean storage[][];
    private int buckets;
    private int bucketItems;
    private final int BUCKET_SIZE = 1000;
    private final int BUCKET_ITEMS_SIZE = 1001;

    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = BUCKET_SIZE;
        bucketItems = BUCKET_ITEMS_SIZE;
        storage = new boolean[buckets][];
    }

    public int bucketKey(int key){
        return key%buckets;
    }

    public int bucketItemsKey(int key){
        return key/bucketItems;
    }

    public void add(int key) {
        int bucket = bucketKey(key);
        int bucketItem = bucketItemsKey(key);

        if(storage[bucket]==null){
            storage[bucket] = new boolean[bucketItems];
        }
        storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = bucketKey(key);
        int bucketItem = bucketItemsKey(key);

        if(storage[bucket]==null) {
            return;
        }
        storage[bucket][bucketItem] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucketKey(key);
        int bucketItem = bucketItemsKey(key);

        if(storage[bucket]==null) {
            return false;
        }
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
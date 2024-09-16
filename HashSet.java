/*
//Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
    I'm getting an error with the bucket()
    it's giving me arithmatic error: divide by zero

// Your code here along with comments explaining your approach


*/




class MyHashSet {
    /*
    declare variables;
    * */
    private boolean[][] storage;
    private int buckets;
    private int bucketItems;

    private int bucketItem(int key){
        return key / bucketItems;
    }
    private int bucket(int key){
        return key % buckets;
    }
    public MyHashSet() {
        int buckets = 1000;
        int bucketItems = 1001;
        storage = new boolean[buckets][];
    }

    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if (storage[bucket]==null){
            storage[bucket] = new boolean[bucketItems];
        }
        storage[bucket][bucketItem]=true;
    }

    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if (storage[bucket] != null){
            storage[bucket][bucketItem]=false;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if (storage[bucket]==null) return false;
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

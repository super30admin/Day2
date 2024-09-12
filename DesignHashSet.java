// Time Complexity    : all operations O(1)
// Space Complexity   : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this    : No


// Your code here along with comments explaining your approach


class MyHashSet {

    int buckets = 1000, bucketItems = 1001;
    boolean[][] dataStorage;

    /** Initialize your data structure here. */
    public MyHashSet() {
        dataStorage = new boolean[buckets][];
    }

    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);

        if(dataStorage[bucket] == null) {
            dataStorage[bucket] = new boolean[bucketItems];
        }
        dataStorage[bucket][bucketItem] = true;
    }

    private int bucket(int key) {
        return key % buckets;
    }

    private int bucketItem(int key) {
        return key / bucketItems;
    }
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);

        if(dataStorage[bucket] != null) {
            dataStorage[bucket][bucketItem] = false;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);

        if(dataStorage[bucket] != null) {
            return dataStorage[bucket][bucketItem];
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
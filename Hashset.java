
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : storage[bucket] = new boolean[bucketItems]; syntax

// Your code here along with comments explaining your approach

// Two Nested arrays with double hashing technique - Edge case for 1millionth element. 

class MyHashSet {
    private boolean[][] storage;
    int buckets;
    int bucketitems;

    public MyHashSet() {
        buckets = 1000;
        bucketitems = 1000;
        storage = new boolean[this.buckets][];
    }

    private int bucket(int key) {
        return key % buckets;
    }

    private int bucketitem(int key) {
        return key / bucketitems;
    }

    public void add(int key) {
        int bucket = bucket(key);
        int bucketitem = bucketitem(key);
        if (storage[bucket] == null) {
            if (bucket == 0) {
                storage[bucket] = new boolean[bucketitems + 1];
            } else {
                storage[bucket] = new boolean[bucketitems];
            }
        }
        storage[bucket][bucketitem] = true;
    }

    public void remove(int key) {
        int bucket = bucket(key);
        int bucketitems = bucketitem(key);
        if (storage[bucket] == null) {
            return;
        } else {
            storage[bucket][bucketitems] = false;
        }
    }

    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketitems = bucketitem(key);
        if (storage[bucket] == null) {
            return false;
        }
        return storage[bucket][bucketitems];
    }
}

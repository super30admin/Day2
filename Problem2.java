// Time Complexity : O(logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
class MyHashSet {
    private boolean[][] storage;
    int buckets;
    int bucketsItems;

    /** Initialize your data structure here. */
    public MyHashSet() {
        storage = new boolean[1000][];
        buckets = 1000;
        bucketsItems = 1000;
    }

    // hashing function for parent array
    public int bucket(int key) {
        return key % buckets;
    }

    // hashing function for nested array
    public int bucketItem(int key) {
        return key / bucketsItems;
    }

    /*check if parent array is present, if its not present create a new nested array*/
    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null) {
            if(bucket == 0) {
                storage[bucket] = new boolean[bucketsItems + 1];
            } else {
                storage[bucket] = new boolean[bucketsItems];
            }
        }
        storage[bucket][bucketItem] = true;
    }

    /*remove item and set it to false*/
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null) {
            return;
        }
        storage[bucket][bucketItem] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null) {
            return false;
        }
        return storage[bucket][bucketItem];
    }
}
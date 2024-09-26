// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashSet {
    int buckets;
    int bucketItems;
    boolean[][] storage;
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }

    private int getBucket(int key){ // hashing function 1
        return (key % buckets);
    }

    private int getBucketItems(int key){ // hashing function 2
        return (key / bucketItems);
    }

    public void add(int key) {
        // Get unique hashing values for each key - value pair
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);

        // Get unique hashing values for each key - value pair
        if(storage[bucket] == null){
            if(bucket == 0){ // There is a need for one extra array element if the key is one million
                storage[bucket] = new boolean[bucketItems + 1];
            } else {
                storage[bucket] = new boolean[bucketItems];
            }
        }
        // Store the value
        storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        // Get unique hashing values for each key - value pair
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);

        // If the sub-array is null then return else set the element = false
        if(storage[bucket] == null) return;
        storage[bucket][bucketItem] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        // Get unique hashing values for each key - value pair
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);

        // If the sub-array is null then return else return the element
        if (storage[bucket] == null) return false;
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
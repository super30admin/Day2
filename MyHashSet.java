// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes


class MyHashSet {


    /** Double Hashing */


    /** Declare the boolean storage 2 dimensional array*/
    private boolean [][] storage;


    /** Initializing two buckets one for primary and other for secondary array */
    int buckets;
    int bucketItems;
    /** Initialize your data structure here. */
    public MyHashSet() {

        /** only initializing first boolean primary array */
        storage = new boolean[1000][];
        buckets = 1000;
        bucketItems = 1000;


    }


    /** calculating index key for the first bucket primary array */
    public int bucketIndex(int key) {
        return key % buckets;
    }


    /** calculating index key for the second bucket secondary array */
    public int bucketItemsIndex(int key) {

        return key / bucketItems;

    }

    public void add(int key) {

        /** calculate the index */
        int bucket = bucketIndex(key);
        int bucketItem = bucketItemsIndex(key);


        /** covering the edge case when including 1000000 case if included and checking the the bucket position if it is null*/
        if(storage[bucket] == null) {

            if(bucket==0) {
                /** add 1 more bucket item if including edge case */
                storage[bucket] = new boolean[bucketItems + 1];

            }
            else {

                storage[bucket] = new boolean[bucketItems];

            }

        }

        storage[bucket][bucketItem] = true;


    }

    public void remove(int key) {

        int bucket = bucketIndex(key);
        int bucketItem = bucketItemsIndex(key);

        /** returning if the bucket is null*/
        if(storage[bucket] == null) return;

        /** removing by converting the boolean to false*/
        storage[bucket][bucketItem] = false;

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {

        int bucket = bucketIndex(key);
        int bucketItem = bucketItemsIndex(key);

        /** returning false if the bucket is null*/
        if(storage[bucket] == null) return false;
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
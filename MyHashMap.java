// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/* 
 * Used similar approach to designing a hashset question.
 * Used double hashing in order to handle collisions.
 * Had to initialize all the elements of the secondary array to -1(in line with the question).
 *  */

import java.util.Arrays;

class MyHashMap {
    private int[][] storage;
    private int buckets;
    private int bucketItems;

    public MyHashMap() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new int[buckets][];
    }

    public int bucket(int key) {
        return key % buckets;
    }

    public int bucketItem(int key) {
        return key / bucketItems;
    }

    public void put(int key, int value) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if (storage[bucket] == null) {
            if (bucket == 0) {
                storage[bucket] = new int[bucketItems + 1];
                Arrays.fill(storage[bucket], -1);
            } else {
                storage[bucket] = new int[bucketItems];
                Arrays.fill(storage[bucket], -1);
            }
        }
        storage[bucket][bucketItem] = value;

    }

    public int get(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if (storage[bucket] == null)
            return -1;
        return storage[bucket][bucketItem];
    }

    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if (storage[bucket] == null)
            return;
        storage[bucket][bucketItem] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
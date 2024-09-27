package Hashset;

/*
  add method:
  Time complexity : o(1)
  Space complexity : o(n) for the first time array is created
  Space complexity : o(1) after the array is created
  ---------------------------------------------------
  remove method:
  Time complexity : o(1)
  Space complexity : o(1)
  ---------------------------------------------------
  contains method:
  Time complexity : o(1)
  Space complexity : o(1)
  ---------------------------------------------------
  Did this code run succesfully in leetcode : yes
  problems faces : no
  create 2d array with 1000 * 1000 size. basically squareroot of the number of unique elements10 power 6.
   evey element can be stored in a[i][j] where i = element value%1000 and j=value/1000
*/ 

public class MyHashSet {
    boolean[][] storage = null;
    int buckets;
    int bucketItems;

    /** Initialize your data structure here. */
    public MyHashSet() {

        int buckets = 1000;
        int bucketItems = 1000;
        storage = new boolean[buckets][];
    }

    private int bucket(int key) {
        return key % buckets;
    }

    private int bucketItem(int key) {
        return key / bucketItems;
    }

    public void add(int key) {
        if (storage[bucket(key)] == null) {
            storage[bucket(key)] = new boolean[bucketItems];
        }
        storage[bucket(key)][bucketItem(key)] = true;
    }

    public void remove(int key) {
        if (contains(key)) {
            storage[bucket(key)][bucketItem(key)] = false;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {

        if (storage[bucket(key)] == null) {
            return false;
        }
        return storage[bucket(key)][bucketItem(key)];
    }

}

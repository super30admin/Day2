class MyHashSet {
    // Time Complexity : O(1)
    // Space Complexity : O(1000000)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

    //Approach - create a 2d boolean array of size 1000X1000. Calculate hash value of the key and its location in the boolean array.
    //set it to true for add operation, false for remove operation and return the boolean value at that index and location in the 2d array
    //for contains operation.
    int buckets = 1000;
    int bucketsize = 1000;
    boolean[][] storage;
    public MyHashSet() {
        storage = new boolean[buckets][];
    }

    public void add(int key) {
        int index = key%buckets;
        int loc = key/buckets;
        if(storage[index] == null) {
            if(index == 0) {
                storage[index] = new boolean[bucketsize + 1];
            } else{
                storage[index] = new boolean[bucketsize];
            }
            storage[index][loc] = true;
        } else {
            storage[index][loc] = true;
        }
    }

    public void remove(int key) {
        int index = key%buckets;
        int loc = key/buckets;
        if(storage[index] == null) {
            return;
        } else {
            storage[index][loc] = false;
        }
    }

    public boolean contains(int key) {
        int index = key%buckets;
        int loc = key/buckets;
        if(storage[index] == null) {
            return false;
        } else{
            return storage[index][loc];
        }
    }
}
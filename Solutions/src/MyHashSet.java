// Time Complexity :
//Add O(1)
//Remove O(1)
//Contains O(1)
//// Space Complexity :
//O(n^2) Not sure, please let me know if its correct
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Forgot to initialize the bucketItem array which caused an issue, resolution took 5 min.


// Your code here along with comments explaining your approach


class MyHashSet {
    boolean[][] storage;
    int buckets=1000;
    int bucketItems=1000;

    /** Initialize your data structure here. */
    public MyHashSet() {
        storage = new boolean[buckets][];
    }
    private int getBucket(int key){
        return key % buckets;
    }
    private int getBucketItem (int key){
        return key / bucketItems;
    }
    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (storage[bucket]==null){
            storage[bucket] = new boolean[bucketItems];
        }
        storage[bucket][bucketItem]=true;
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (storage[bucket]==null){
            return;
        }
        storage[bucket][bucketItem]=false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (storage[bucket]==null){
            return false;
        }
        return storage[bucket][bucketItem]==true;
    }

    public static void main(String[] args) {
        MyHashSet obj = new MyHashSet();
        obj.add(0);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
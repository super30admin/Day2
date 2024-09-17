// Time Complexity : O(1)
// Space Complexity : O(N) as max we can have size of the input array+1
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/*
used double Hasing to prevent collisions. we can initialize an array of buckets by deciding a size (here I took half of my input size)
and we can create new arrays for each bucket if it is null depending on hash index
 */

class MyHashSet {
    int buckets, bucketItems;
    boolean[][] set;

    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = 1000;
        bucketItems=1001; // edge case scenario when key = 1000000
        set = new boolean[buckets][];
    }
    //DoubleHashing
    //hash1 - mod
    private int bucket(int key){
        return key%buckets;
    }
    //hash2 - divide
    private int bucketItem(int key){
        return key/bucketItems;
    }

    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(set[bucket] == null)
            set[bucket] = new boolean[bucketItems];
        set[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(set[bucket] == null) return;
        set[bucket][bucketItem] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(set[bucket] == null) return false;
        return set[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
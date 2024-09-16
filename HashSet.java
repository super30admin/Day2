// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashSet {
    //considering the input range and ask in the problem, used boolean as it occupies lesser memory than integer
    boolean[][] pool;
    //having 2*2 matrix, considering the input range 0->key->10^6
    //initial bucket filled upon primaryHashKey
    //secondary bucket initialised upon primaryHashKey
    static final int bucketSize = 1000;
    static final int bucketItemSize = 1000;
    public MyHashSet() {
        //initialising the primary bucket
        pool = new boolean[bucketSize][];
    }

    public void add(int key) {
        int bucketIndex = primaryHashKey(key);
        boolean[] innerItems = pool[bucketIndex];
        //if the bucketIndex on initial bucket is empty, we initialse the bucketItems boolean array
        if(innerItems == null) pool[bucketIndex] = new boolean[bucketIndex == 0 ? bucketItemSize + 1: bucketItemSize];
        int bucketItemIndex = secondaryHashKey(key);
        //upon secondaryHashKey, we toggle the value to true
        pool[bucketIndex][bucketItemIndex] = true;
    }

    public void remove(int key) {
        int bucketIndex = primaryHashKey(key);
        boolean[] innerItems = pool[bucketIndex];
        if(innerItems == null) return;
        int bucketItemIndex = secondaryHashKey(key);
        pool[bucketIndex][bucketItemIndex] = false;
    }
    // the tradeoff between space and time complexity, here chosen to go with time complexity,
    // as retrieval process is very quick and unique
    // O(1)
    public boolean contains(int key) {
        int bucketIndex = primaryHashKey(key);
        boolean[] innerItems = pool[bucketIndex];
        if(innerItems == null) return false;
        int bucketItemIndex = secondaryHashKey(key);
        return pool[bucketIndex][bucketItemIndex];
    }

    public int primaryHashKey(int key) {
        return key%bucketSize;
    }
    public int secondaryHashKey(int key) {
        // all values like 1000, 2000, and all will go inside pool[0][secondaryHashKey]
        return key/bucketItemSize;
    }

}
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


import java.util.Arrays;

class MyHashMap {
    private int[][] map;
    private final int BUCKETS;
    private final int BUCKET_ITEMS;
    
    private int bucketHashFunction(int key){
        return key % BUCKETS;
    }
    
    private int bucketItemsHashFunction(int key){
        return key / BUCKET_ITEMS;
    }
    
    public MyHashMap() {
        BUCKETS = 1000;
        BUCKET_ITEMS = 1000;
        map = new int[BUCKETS][];
    }
    
    public void put(int key, int value) {
        int bucket = bucketHashFunction(key);
        int bucketItem = bucketItemsHashFunction(key);
        if(map[bucket] == null){
            if(bucket == 0)
                map[bucket] = new int[BUCKET_ITEMS + 1];
            else
                map[bucket] = new int[BUCKET_ITEMS];
            //In java, default value is 0. input is range from 0 to 10^6.
            // Making default value as -1
            Arrays.fill(map[bucket], -1);
        }
        map[bucket][bucketItem] = value;
    }
    
    public int get(int key) {
        int bucket = bucketHashFunction(key);
        int bucketItem = bucketItemsHashFunction(key);
        if (map[bucket] == null) return -1;
        return map[bucket][bucketItem];
    }
    
    public void remove(int key) {
        int bucket = bucketHashFunction(key);
        int bucketItem = bucketItemsHashFunction(key);
        if (map[bucket] == null) return;
        map[bucket][bucketItem] = -1;
    }
}
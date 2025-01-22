//following the approach by using square root to find the size of the matrix, base array has
// pointers pointing to the nested array at each index. Also keeping a boolean nested array to keep
//track of the value present in the array. Did this because a test case was failing where the value
// was not present in the array and it was returning -1 anyways.
// Time Complexity: o(1).
// Space complexity: o(n)

public class MyHashMap {
    private int [][] storage;
    private int buckets;
    private int bucketItems;
    private boolean[][] isPresent;

    private int bucket(int key){
        return key % buckets;
    }

    private int bucketItem(int key){
        return key / bucketItems;
    }
    public MyHashMap() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new int[buckets][];
        this.isPresent = new boolean[buckets][];
    }
    
    public void put(int key, int value) {
        int bucket = bucket(key);
        if(storage[bucket] == null){
            if(bucket == 0){
                storage[bucket] = new int[bucketItems + 1];
                isPresent[bucket] = new boolean[bucketItems + 1];
            }else{
                storage[bucket] = new int[bucketItems];
                isPresent[bucket] = new boolean[bucketItems + 1];
            }

        }
            int bucketItem = bucketItem(key);
            storage[bucket][bucketItem] = value;
            isPresent[bucket][bucketItem] = true; 
    }
    
    public int get(int key) {
        int bucket = bucket(key);
        if (storage[bucket] == null || !isPresent[bucket][bucketItem(key)]) {
            return -1;
        }
        int bucketItem = bucketItem(key);
        return storage[bucket][bucketItem];
    }
    
    public void remove(int key) {
        int bucket = bucket(key);
        if(storage[bucket] == null) return;
        int bucketItem = bucketItem(key);
        storage[bucket][bucketItem] = -1;
        isPresent[bucket][bucketItem] = false;
    }
}
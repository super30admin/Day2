import java.util.*;
class MyHashMap {
    private int buckets;
    private int bucketItems;
    private int storage[][];

    public MyHashMap() {
        buckets = 1000;
        bucketItems = 1001;
        storage = new int[buckets][];
    }
    
    public void put(int key, int value) {
        int bucketKey = getBucketKey(key);
        int bucketItemKey = getBucketItemKey(key);
        if(this.storage[bucketKey] == null){
            if(bucketKey == 0) {
                this.storage[bucketKey] = new int[bucketItems + 1];
            } else {
                storage[bucketKey] = new int[bucketItems];  
            }
        }
        Arrays.fill(storage[bucketKey], -1);
        this.storage[bucketKey][bucketItemKey] = value;
    }
    
    public int getBucketKey(int key) {
        return key % buckets;
    }
    
    public int getBucketItemKey(int key) {
        return key / bucketItems;
    }
    
    public int get(int key) {
        int bucketKey = getBucketKey(key);
        int bucketItemKey = getBucketItemKey(key);
        if (storage[bucketKey] == null || storage[bucketKey][bucketItemKey] == -1 )         {
            return -1;
        } else return storage[bucketKey][bucketItemKey];
    }
    
    public void remove(int key) {
        int bucketKey = getBucketKey(key);
        int bucketItemKey = getBucketItemKey(key);
        if (storage[bucketKey] != null) {
            storage[bucketKey][bucketItemKey] = -1;
        }  
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
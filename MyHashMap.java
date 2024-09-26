// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;

class MyHashMap {           //Used double hashing for storing the values of all the keys in the hashmap.
    int buckets;
    int bucketItems;
    int [][] storage;

    public MyHashMap() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new int[buckets][];
    }
    public int getBucket(int key){
        return key%1000;
    }
    public int getBucketItem(int key){
        return key/1000;
    }
    public void put(int key, int value) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket]==null){
            if(bucket ==0){
                storage[bucket] = new int[bucketItems+1];
            }
            else
                storage[bucket] = new int[bucketItems];
            Arrays.fill(storage[bucket],-1);
        }
        storage[bucket][bucketItem] = value;
    }

    public int get(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket]==null)
            return -1;
        return storage[bucket][bucketItem];
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket]==null)
            return;
        if(storage[bucket][bucketItem]==-1)
            return;
        else
            storage[bucket][bucketItem]=-1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
import java.util.*;

// Time Complexity : O(n) for all functions.
// Space Complexity : O(n) for size of array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class MyHashSet {

    boolean [][] storage;
    int buckets;
    int bucketItems;
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }
    private int bucket(int key){
        return key%buckets;
    }
    private int bucketItem(int key){
        return key/bucketItems;
    }

    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket]==null){
            if(bucket==0){
                storage[bucket] = new boolean[bucketItems+1];
            }
            else{
                storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket]==null) return;
        storage[bucket][bucketItem] = false;
    }

    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null) return false;
        return storage[bucket][bucketItem];

    }

    public static void main(String [] args){
        MyHashSet hashSet = new MyHashSet();

        hashSet.add(1);

        hashSet.add(2);

        System.out.println(hashSet.contains(1));    // returns true

        System.out.println(hashSet.contains(3));    // returns false (not found)

        hashSet.add(2);

        System.out.println(hashSet.contains(2));    // returns true

        hashSet.remove(2);

        System.out.println(hashSet.contains(2));
    }
}
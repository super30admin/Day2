/*
Time complexities: put: O(1) //
                   remove: O(1)  // Calculaitng index and making the value as -1
                   get: O(1) // Calculating index and directly accessing memory
Space:  O(1) No auxilary mem required to calculate any of the methods 
*/

import java.util.Arrays;

class MyHashMap {
    //Buckets will be pointers to bucketitems similar to hashset
    int buckets = 1000;
    int bucketItems = 1000;
    int[][] map;
    //Declare hashmap
    public MyHashMap() {
        map = new int[buckets][];
    }

    //Hash functions
    private int getBucketIndex(int key){
        return key % buckets;
    }
    private int getBucketItemsIndex(int key){
        return key / buckets;
    }
    // Put method calculate index and set value at hashed index of key
    // Fill all elements with -1 because when map does not containks key then return -1
    public void put(int key, int value) {
        int bucketIndex = getBucketIndex(key);
        int bucketItemIndex = getBucketItemsIndex(key);
        if(map[bucketIndex] == null){
            if(bucketIndex == 0){
                map[bucketIndex] = new int[bucketItems+1];
                
            }else{
                map[bucketIndex] = new int[bucketItems];
            }
            Arrays.fill(map[bucketIndex], -1);
        }
        map[bucketIndex][bucketItemIndex] = value;
    }
    // Calculate hashed index and return value
    public int get(int key) {
        int bucketIndex = getBucketIndex(key);
        int bucketItemIndex = getBucketItemsIndex(key);
        if(map[bucketIndex] == null){
            return -1;
        }
        return map[bucketIndex][bucketItemIndex];
    }
    //By default a
    public void remove(int key) {
        int bucketIndex = getBucketIndex(key);
        int bucketItemIndex = getBucketItemsIndex(key);
        if(map[bucketIndex] == null){
            return;
        }
        
        map[bucketIndex][bucketItemIndex] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
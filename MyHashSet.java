// Time Complexity : O(1) for all the operation
// Space Complexity : O(1000*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


public class MyHashSet {

    int buckets;
    int bucketItems;
    boolean [][] storage;

    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1001; // set to 1001 for the edge cases when input is 1,000,000
        storage = new boolean[buckets][];
    }

    public void add(int key) {
        int index1 = hashFunction1(key);
        //check if the storage at index1 is null then initialize the 2nd array
        if(storage[index1]==null){
            storage[index1] = new boolean[bucketItems];
        }
        int index2 = hashFunction2(key);
        storage[index1][index2] = true;
    }

    public void remove(int key) {
        int index1 = hashFunction1(key);
        int index2 = hashFunction2(key);
        //check if the array at storage at index is initialized, if true then set the
        // value for corresponding index as false
        if(storage[index1]!=null){
            storage[index1][index2] = false;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index1 = hashFunction1(key);
        int index2 = hashFunction2(key);
        //if the element exist in the hash set the second array should be initialized
        if(storage[index1]==null){
            return false;
        } else{
            return storage[index1][index2];
        }
    }

    public int hashFunction1(int key){
        return key % buckets;
    }

    public int hashFunction2(int key){
        return key/buckets;
    }
}

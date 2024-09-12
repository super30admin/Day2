import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Time Complexity :  Worst Case could be O(n), Depends on the number of Buckets here.
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashSet {

    /* Size of the Array. Also used for Hashing */
    private final int ARRAY_SIZE = 100;
    /* This is the List which will contain linked list. Could be called Parentlist*/
    private List<List<Integer>> bucketList;

    /** Initialize your data structure here. */
    public MyHashSet() {
        bucketList = new ArrayList<>(ARRAY_SIZE);
        for(int i = 0; i < ARRAY_SIZE; i++) {     
        bucketList.add(null);
        }
    }
    
    /**
     * This method finds the correct bucket from the bucketList, and then adds the element to that bucket.
     * We create list of elements/keys because there could be more than one element belonging to that bucket.
     * @param key is the key element to be added.
     */
    public void add(int key) {
        int index = key % ARRAY_SIZE;                   // Getting the hash value and using that as an Index.
        List<Integer> bucket = bucketList.get(index);   // Creating a List to store individual buckets.
        if(bucket != null) {                            // If the bucket already contains a list, simply add the key.
            if(!bucket.contains(key)) {
                bucket.add(key);
            }
        }
        else {
            List<Integer> keyList = new LinkedList<>(); // If the bucket is empty, we create a new list to add keys
            keyList.add(key);
            bucketList.set(index, keyList);
        } 
    }
    
    /**
     * This method removes the key element from the bucketList
     * @param key is the keyElement to be removed
     */
    public void remove(int key) {
        int index = key % ARRAY_SIZE;
        List<Integer> bucket = bucketList.get(index);
        if(bucket != null) {
            bucket.remove(Integer.valueOf(key));       // We use Integer.value to make sure we remove the element
        }                                               // and not the that location/index in that list.
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = key % ARRAY_SIZE;
        List<Integer> bucket = bucketList.get(index);;
        return bucket != null && bucket.contains(key); 
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
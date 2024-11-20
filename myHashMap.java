// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I have faced problem during removing element because of the changed size of the list

import java.util.*;

class MyHashMap {

    // intialize bucket and array of list of key value pair
    private int buckets;
    private List<Bucket>[] storage;

    public MyHashMap() {

        // initialize bucket with 1000 as there are 1000000 entry limit
        buckets = 1000;

        // make array of size bucket for storing hashed data
        storage = new LinkedList[buckets];
        // intially all the list in array should be null
        for (int i = 0; i < buckets; i++) {
            storage[i] = null;
        }
    }

    // for hashing function bucket
    public int bucket(int key) {
        return key % buckets;
    }

    public void put(int key, int value) {
        // get hashed index of the key
        int bucket = bucket(key);

        // get the list of the where we are going to add or update the map
        List<Bucket> bucketItems = storage[bucket];

        // if list is null that means there is no elements in the list. So, first we
        // have to intialize the list.
        if (bucketItems == null) {

            // initilaize the list
            List<Bucket> list = new LinkedList<>();

            // add key value pair in the list
            list.add(new Bucket(key, value));

            // update the list
            storage[bucket] = list;
        } else {

            // else there is some elements in the list so we traverse through list that that
            // key is already in the list or not
            for (Bucket bucketItem : bucketItems) {

                // if key already available in the list then we update the value corresponding
                // to key
                if (bucketItem.key == key) {
                    bucketItem.value = value;
                    return;
                }

            }

            // if key is not available in the list then we first get the list and then add
            // key value pair in the list and then update corresponding index of the array
            List<Bucket> list = storage[bucket];
            list.add(new Bucket(key, value));
            storage[bucket] = list;
        }

    }

    public int get(int key) {
        // get hashed index of the key
        int bucket = bucket(key);

        // get the list of the where we may find our wanted element
        List<Bucket> bucketItems = storage[bucket];

        // if list is null that means there is no element in the list so, we return -1;
        if (bucketItems == null) {
            return -1;
        }

        // we traverse through all the elements in the list if we find wanted value then
        // we return it.
        for (Bucket bucketItem : bucketItems) {
            if (bucketItem.key == key)
                return bucketItem.value;
        }

        // else we return -1
        return -1;
    }

    public void remove(int key) {
        // get hashed index of the key
        int bucket = bucket(key);
        // get the list of the where we may find our wanted element
        List<Bucket> bucketItems = storage[bucket];

        // here we declare varible for the element we want to remove
        Bucket toRemove = null;

        // if list is null that means there is no element in the list so, we return
        if (bucketItems == null) {
            return;
        }
        // we traverse through all the elements in the list for remove key value pair
        // then
        // we return it.
        for (Bucket bucketItem : bucketItems) {

            // if we find our key value pair then we store it in toRemove element(here we
            // can remove directly from the list but sometime it throw error and change the
            // size of the list)
            if (bucketItem.key == key)
                toRemove = bucketItem;
        }

        // if there is no element to remove then we return else we remove element from
        // the list
        if (toRemove == null)
            return;
        bucketItems.remove(toRemove);

    }

    class Bucket {

        // class for storing key value pair
        private int key;
        private int value;

        // constructor for storing key value pair
        Bucket(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);
        map.put(4, 40);
        System.out.println("key: " + 4 + " value: " + map.get(4));
        map.put(4, 45);
        System.out.println("key: " + 4 + " value: " + map.get(4));

    }

}
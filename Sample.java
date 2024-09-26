// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : -

class MyHashSet {
    boolean[][] storage;
    private int bucketLength;
    private int bucketItemsLength;

    MyHashSet(){
        bucketLength = 1000;
        bucketItemsLength = 1000;
        storage = new boolean[bucketLength][];
    }

    // Returns bucket index for the given key
    private int bucketIndex(int key){
        return key % bucketLength;
    }

    // Returns bucket item index for the given key
    private int bucketItemIndex(int key){
        return key / bucketItemsLength;
    }

    public void add(int key) {
        int bucketIndex = bucketIndex(key);
        int bucketItemIndex = bucketItemIndex(key);
        if(storage[bucketIndex] == null){
            int size = bucketIndex == 0 ? bucketItemsLength+1 : bucketItemsLength;
            storage[bucketIndex] = new boolean[size];
        }
        storage[bucketIndex][bucketItemIndex] = true;
    }

    public void remove(int key) {
        int bucketIndex = bucketIndex(key);
        int bucketItemIndex = bucketItemIndex(key);
        if(storage[bucketIndex] != null)
            storage[bucketIndex][bucketItemIndex] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketIndex = bucketIndex(key);
        int bucketItemIndex = bucketItemIndex(key);
        if(storage[bucketIndex] == null)
            return false;
        else
            return storage[bucketIndex][bucketItemIndex];
    }
}

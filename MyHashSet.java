// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyHashSet {
    private boolean [][]storage;
    int buckets;
    int bucketsItems;

    /** Initialize your data structure here. */
    public MyHashSet() {
        storage = new boolean[1000][];
        buckets = 1000;
        bucketsItems = 1000;
    }
    
    private int bucket(int key){
        return key % buckets;
    }
    
    private int bucketItem(int key){
        return key / bucketsItems;
    }
    
    public void add(int key) {
        int bucketsHash = bucket(key);
        int bucketsItemsHash = bucketItem(key);
        if(storage[bucketsHash] == null){
            if(bucketsHash == 0)
                storage[bucketsHash] = new boolean[bucketsItems + 1];
            else
                storage[bucketsHash] = new boolean[bucketsItems];
        }
        storage[bucketsHash][bucketsItemsHash] = true;
    }
    
    public void remove(int key) {
        int bucketsHash = bucket(key);
        int bucketsItemsHash = bucketItem(key);
        if(storage[bucketsHash] == null)
            return;
        storage[bucketsHash][bucketsItemsHash] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketsHash = bucket(key);
        int bucketsItemsHash = bucketItem(key);
        if(storage[bucketsHash] == null)
            return false;
        return storage[bucketsHash][bucketsItemsHash];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
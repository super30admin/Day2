// Time Complexity : all operations O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class MyHashSet {

    final int buckets = 1000, bucketItems = 1001;
    boolean[][] data;
   
    /** Initialize your data structure here. */
    public MyHashSet() {
        data = new boolean[buckets][];
    }
    
    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        
        if(data[bucket] == null) {
            data[bucket] = new boolean[bucketItems];
        }
        data[bucket][bucketItem] = true;
    }
    
    private int bucket(int key) {
        return key % buckets;
    }
    
    private int bucketItem(int key) {
        return key / bucketItems;
    }
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        
        if(data[bucket] != null) {
            data[bucket][bucketItem] = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        
        if(data[bucket] != null) {
            return data[bucket][bucketItem];
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
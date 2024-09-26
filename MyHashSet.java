// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashSet {
    
    int buckets;                // Primary array
    int bucketItems;            // Secondary array
    boolean[][] data;

    public MyHashSet() {
        // Range 0 - 10^6.
        buckets = 1000;
        bucketItems = 1000;
        // Initialize the primary array to be filled with nulls.
        data = new boolean[buckets][]; 
    }
    
    public void add(int key) {
        int bucket = key % buckets;                 // Get the primary array index.
        int bucketItem = key / bucketItems;         // Get the secondary array index.
        if(data[bucket] == null) {
            if(bucket == 0) {
                data[bucket] = new boolean[bucketItems + 1];    // For 10^6.
            }
            else {
                data[bucket] = new boolean[bucketItems];
            }
        }
        data[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = key % buckets;
        int bucketItem = key / bucketItems;
        if(data[bucket] == null) {
            return;
        }
        data[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
        int bucket = key % buckets;
        int bucketItem = key / bucketItems;
        if(data[bucket] == null) {
            return false;
        }
        return data[bucket][bucketItem];       // Returns true or false.
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
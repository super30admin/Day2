// Time Complexity : add : O(1), remove O(1), contains: O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// we use a boolean multi dimensional array to store true if value is present else false



class MyHashSet {
    boolean[][] storage;
    int buckets;
    int bucketItems;
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }

    public void add(int key) {
        int bucket = getBucketHash(key); // get index of the primary array
        int bucketItem = getBucketItemHash(key); // get index of the secondary array
        if(storage[bucket] == null){ // if primary array does not exist
            if(bucket == 0) // check if its the first array to be created
                storage[bucket] = new boolean[bucketItems + 1]; // create an array of 1 extra size to handle 10^6 case
            else
                storage[bucket] = new boolean[bucketItems];
        }
        storage[bucket][bucketItem] = true; //store true in the respective key location
    }

    public void remove(int key) {
        int bucket = getBucketHash(key);
        int bucketItem = getBucketItemHash(key);
        if(storage[bucket] == null) // return if array is not initialized as it indicates key is not present
            return;
        else
            storage[bucket][bucketItem] = false; // if present make the value false
    }

    public boolean contains(int key) {
        int bucket = getBucketHash(key);
        int bucketItem = getBucketItemHash(key);
        if(storage[bucket] == null)
            return false; // return flase if the primary array is not initialized
        else
            return storage[bucket][bucketItem]; //else return the respective value stored in the location.
    }
    public int getBucketHash(int key){
        return key % 1000;
    }
    public int getBucketItemHash(int key){
        return key / 1000;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

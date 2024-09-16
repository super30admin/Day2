// Time Complexity : O(1)  for add(), remove() and contains()
// Space Complexity : O(N) considering the secondary array
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no
class MyHashSet {
    
    boolean[][] storage;
    int bucket;
    int bucketItems;

    /** Initialize your data structure here. */
    public MyHashSet() {
        bucket = 1000; //squareroot of the upperbound
        bucketItems = 1000; 
        storage = new boolean[bucket][]; // initially just initializing the primary array
    }
    
    public int getBucket(int key){ //hashing function for primary array
        return key%bucket;
    }
    
     public int getBucketItems(int key){ // hashing function for secondary array
        return key/bucketItems;
    }
    
    
    public void add(int key) { 
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);
        //check if the bucket is null,if null create a secondary array
        if(storage[bucket] == null){
            //special case for 10^6 key value where the size for items would increase by 1
            if(bucket == 0){
                storage[bucket] = new boolean[bucketItems+1];
            }
            else{
                storage[bucket] = new boolean[bucketItems];
            }
        }
        
        storage[bucket][bucketItem] = true; // mark true for that key
        
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItems = getBucketItems(key);
        if( storage[bucket] == null){ // suggests key does not exist
            return;
        }
        storage[bucket][bucketItems] = false; //false indicates element does not exist
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItems = getBucketItems(key);
        if( storage[bucket] == null){ // suggests key does not exist
            return false;
        }
        return storage[bucket][bucketItems];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
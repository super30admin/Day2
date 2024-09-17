// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class MyHashSet {

    private boolean [][] storage; //Boolean matrix
    private int buckets; //Size of primary array
    private int bucketItems; //Size of secondary array 
    
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];  //Only the primary array is made, we don't require to make secondary array until there is a need to.
    }
    
    //First Hash Function
    private int getBucket (int key){
        return (key % buckets);
    }
    
    //Second Hash Function
    private int getBucketItem (int key){
        return (key / bucketItems);
    }
    
    public void add(int key) {
        // Get unique hash values for each key-value pair
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        
        if(storage[bucket] == null){ //Pointer
            if(bucket == 0){  // Requires one extra array element if the key is 1000,2000,3000,....1000000
                storage[bucket] = new boolean[bucketItems + 1]; 
            }else{
                storage[bucket] = new boolean[bucketItems];
            }
        }
        
        //Storing the value
        storage[bucket][bucketItem] = true; 
    }
    
    public void remove(int key) {
        // Get unique hash values for each key-value pair
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        
        // If the nested(secondary) array is null then return else set the element to false
        if(storage[bucket] == null) return;
        storage[bucket][bucketItem] = false;
    }
    
    
    public boolean contains(int key) { //Returns true if set contains the specified element
        // Get unique hash values for each key-value pair
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        
        // If the nested(secondary) array is null then return false else return the element
        if(storage[bucket] == null) return false;
        return storage[bucket][bucketItem];

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

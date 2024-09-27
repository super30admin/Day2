class MyHashSet {
    
    int buckets, bucketItems;
    boolean storage[][];
    
   
    /** Initialize your data structure here. */
    //modulo function for first array
   
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1001;
        storage = new boolean[buckets][];
    }
    private int bucket(int key){
        return key%buckets;
    }
    private int bucketItem(int key){
        return key/buckets;
    }
    
    public void add(int key) {
       int bucket = bucket(key);
       int bucketItem = bucketItem(key);
       if(storage[bucket]==null)
           storage[bucket] = new boolean[bucketItems];
        storage[bucket][bucketItem]= true;
        
        
    }
    
    public void remove(int key) {
    int bucket = bucket(key);
       int bucketItem = bucketItem(key);
       if(storage[bucket]!=null)
           storage[bucket][bucketItem]= false;
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
       int bucket = bucket(key);
       int bucketItem = bucketItem(key);
       if(storage[bucket]!=null)
           return storage[bucket][bucketItem];
        return false;
    }
}
/*
Time Complexity :
With the selection of right size of the array (sqrt(max_dataset)), all the operations
of the hashset are performed in O(1)

Space Complexity : O(m+n), m is the number of buckets and n is the 
number of bucket items

Did this code successfully run on Leetcode :yes

Any problem you faced while coding this :No

Your code here along with comments explaining your approach
- Double hashing technique is used.
- The size of the array of buckets and bucketItems is determined based on the the given dataset.
Here, the range is 1 to 1000000. Therefore, bucket is 1000 and bucketItems is 1001[as we will need
to store the value of 0 in the first bucket at index 0]
- Initialize only the bucket array initially
- Add operation: initialize bucketIterms array if it is null previously and set it to
true based on the index obtained from the hash funtion
- Remove operation: check if the element is present and return the boolean value from the
corresponding index. 
- Contains : Return the boolean value contained in the corresponding index. Else, if
 bucket is not initialized with bucketItems return false.
*/

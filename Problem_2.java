// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// HashSet to store the values is setup by two storage area, main bucket and the bucket items, this // will help to reduce down the unnecessary storage area.
// Because of that two hasing function is used to mentioned the hashset
// Your code here along with comments explaining your approach

class MyHashSet {

    Boolean [][] hashSet;
    int mainBucket;
    int bucketItems;
    /** Initialize your data structure here. */
    public MyHashSet() {
        mainBucket = 1000;
        bucketItems = 1000;
        hashSet = new Boolean[mainBucket][]; // innitialize the main bucket
    }

    private int myBucket(int key){
        return key % mainBucket; // hash function 1
    }

    private int myBucketItems(int key){
        return key / bucketItems; // hash function 2
    }

    public void add(int key) {
        int i = myBucket(key);
        int j = myBucketItems(key);
        if( hashSet[i] == null){
            if(i == 0){
                hashSet[i] = new Boolean[bucketItems + 1]; // increaseing the secondary bucket                                                                  // becuase 1000000 may go outof bound if                                                            // not taken care of. ( at index 0)
            }else{
                hashSet[i] = new Boolean[bucketItems];   //setting up the sub array for storage.
            }
        }
        hashSet[i][j] = true; // adding value to the hashset
    }

    public void remove(int key) {
        int i = myBucket(key);
        int j = myBucketItems(key);
        if( hashSet[i] == null) return; // return if empty hashset
        hashSet[i][j] = false; // removing value to the hashset
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int i = myBucket(key);
        int j = myBucketItems(key);
        if( hashSet[i] == null) return false; // check for the hashSet subarray is empty or not
        if( hashSet[i][j] == null) return false; // check if the hashset don't have null value
        return hashSet[i][j]; // return the value
    }
}

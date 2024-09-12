// Problem :  Design HashSet
// Time Complexity :O(1)
// Space Complexity : O(n) // where n is range of elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 


// Your code here along with comments explaining your approach
class MyHashSet {
      
    private boolean [][] storage;
    private int buckets;
    private int bucketItems;
    
    private int bucket(int key)
    {
        return key%buckets;            // find bucket number
    }
    
    private int bucketItem(int key)
    {
         return key/bucketItems;       // find position in a bucket
    }
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1001;
        storage = new boolean[buckets][];
    }
    
    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket]==null)  // check whether bucket is empty or not
        {
            storage[bucket] = new boolean[bucketItems]; // create storage in a bucket
        }
        storage[bucket][bucketItem]=true; // mark the position of the bucket indicating element is present
    }
    
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket]==null) return ; // bucket is empty simply return 
        storage[bucket][bucketItem]=false; // if element present mark it false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket]!=null) // if bucket has elements
        {
            return  storage[bucket][bucketItem];  // return status
        }
        return false; // else simply return false; 
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
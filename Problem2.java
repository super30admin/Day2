/* Design a HashSet without using any built-in hash table libraries.
To be specific, your design should include these functions:

add(value): Insert a value into the HashSet. 

contains(value) : Return whether the value exists in the HashSet or not.

remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
*/

// Time Complexity : 0(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//in this approach we will be trying double hashing to reduce the space complexity from 10^6 to 10^3
//we will be maintaing two buckets and bucketsItems array for 10^3 each
//we will define two hash functions: hashfunction1(modular function) hashfunction2(where divide function)
class MyHashSet {
    //Double Hashing
    //Chaining
    int buckets = 1000; //[,,,,,]
    int bucketItems = 1000;//[,[],,,,,]
    boolean [][] storage = new boolean[buckets][];
    /** Initialize your data structure here. */
    
    //first hash function
    private int bucket(int key){
        return key%buckets; //key % 1000
    }

    //second hash function
    private int bucketItem(int key){
        return key/bucketItems; //key / 10000
    }

    public MyHashSet() {
        
    }
    
    public void add(int key) {
        //parent index
        int bucket = bucket(key);
        //nested array index at that particular index
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null){
            storage[bucket] = new boolean[bucketItems];
        }
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        //parent index
        int bucket = bucket(key);
        //nested array index at that particular index
        int bucketItem = bucketItem(key);
        if(storage[bucket] != null){
            storage[bucket][bucketItem] = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] != null){
            return storage[bucket][bucketItem];
        }else{
            return false;
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
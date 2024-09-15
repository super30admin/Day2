/**
 
Time Complexity: O(1)
Space Complexity: O(n^2)
LeetCode: Yes

Create a boolean hashset with two hash functions - mod and division. 
Initialize the array
Mod determines the bucket and division determines the bucketitems. 
Based on result update the array **/

class MyHashSet {
    boolean[][] storage;
    int buckets = 1000;
    int bitems = 1000;
/** Initialize your data structure here. */
public MyHashSet() {
   storage = new boolean[buckets][];
}

//hash1
private int bucket(int key){
    return key%buckets ;
    
}
 
//h2
private int bucketitems(int key){
    return key /bitems;
}

public void add(int key) {
    int bucket = bucket(key);
    int bucketitems = bucketitems(key);
    if(storage[bucket] == null){
        storage[bucket] = new boolean[bitems];
    }
    storage[bucket][bucketitems] = true;
    
}

public void remove(int key) {
    int bucket = bucket(key);
    int bucketitems = bucketitems(key);
    if(storage[bucket] != null){
    storage[bucket][bucketitems] = false;       
}
    
}
/** Returns true if this set contains the specified element */
public boolean contains(int key) {
    int bucket = bucket(key);
    int bucketitems = bucketitems(key);
    
    return storage[bucket] != null && storage[bucket][bucketitems]== true ;
}
}

/**
* Your MyHashSet object will be instantiated and called as such:
* MyHashSet obj = new MyHashSet();
* obj.add(key);
* obj.remove(key);
* boolean param_3 = obj.contains(key);
*/
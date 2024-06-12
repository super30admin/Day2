package s30Coding;

//Time Complexity
//	add :- O(1)
// remove :- O(1)
//contains : O(1)


// Space complexity :- O(1)

//Code runs successfully on LeetCode

//No difficulties

public class MyHashSet {
	/** Initialize your data structure here. */
	
    /** Initialize your data structure here. */
    int buckets;
    int bucketItems;
	 boolean[][] set;
    public MyHashSet() {
        buckets = 1001;
        bucketItems = 1000;
        set = new boolean[buckets][];
    }
    
    public int bucket(int key) {
    	return key%buckets;
    }
    public int bucketItems(int key) {
    	return  key/bucketItems;
    }
    
    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItems(key);
        if(set[bucket] == null){
            set[bucket] = new boolean[bucketItems];
        }
        set[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItems(key);
        if(set[bucket] != null){
        set[bucket][bucketItem] = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItems(key);
        if(set[bucket] == null){
            return false;
        }
        return set[bucket][bucketItem];
    }
}

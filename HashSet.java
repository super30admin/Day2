// Time Complexity : O(1)
// Space Complexity : O(N*M) where N is number of buckets and M is number of bucket items
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didn't get any idea other than creating array of 10^6+1 values and getting it in O(1) time
//This seems to be really efficient compared to my approach


/*
1. Use a 2-dimensional boolean array huge enough to store range of values inserted. 
2. Use double hashing technique (with 2 hash-functions) to handle collisions and allocate bucket space only if a value is being inserted in that bucket. 
3. Calculate bucket and bucketItem based on hash functions and add, remove and check if it contains key at set[bucket][bucketItem]
*/

class MyHashSet {
    
    int buckets, bucketItems; 
    boolean[][] hashSet;
    
    public MyHashSet() {
        buckets = 1000; 
        bucketItems = 1001;
        hashSet = new boolean[buckets][];
    }
    
    private int bucket(int key) {
        return key % buckets;
    }
    
    private int bucketItem(int key) {
        return key / bucketItems;
    }
    
    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(hashSet[bucket] == null)
            hashSet[bucket] = new boolean[bucketItems];
        hashSet[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(hashSet[bucket] != null)
            hashSet[bucket][bucketItem] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(hashSet[bucket] != null && hashSet[bucket][bucketItem] == true)
            return true;
        
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */


// Implementation before class

class MyHashSet {

    int[] set;
     MyHashSet() {
        set = new int[1000001];
        Arrays.fill(set,-1);
    }
    
    public void add(int key) {
        set[key] = key;
    }
    
    public void remove(int key) {
        set[key] = -1;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return set[key] == -1? false: true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

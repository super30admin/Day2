// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MyHashSet {
    
    boolean[][] storage;
    int bucketSize;
    int itembucketSize;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        storage = new boolean[1000][];
        bucketSize = 1000;
        itembucketSize = 1000;
    }
    
    public void add(int key) {
        int bucket = hashfunc1(key);
        int itembucket = hashfunc2(key);
        if(bucket == 0 && storage[bucket] == null){
            storage[bucket] = new boolean[1001];
        }
        if(storage[bucket] == null){
            storage[bucket] = new boolean[1000];
        }
            storage[bucket][itembucket] = true;
    }
    
    public void remove(int key) {
        int bucket = hashfunc1(key);
        int itembucket = hashfunc2(key);
        if(storage[bucket] != null){
            storage[bucket][itembucket] = false;
        }
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = hashfunc1(key);
        int itembucket = hashfunc2(key);
        if(storage[bucket] != null){
            return storage[bucket][itembucket];
        } else {
            return false;
        }
        
    }
    
    public int hashfunc1(int key){
        return key%bucketSize;
    }
    
    public int hashfunc2(int key){
        return key/itembucketSize;
    }
    
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
// Time Complexity : getKey - O(1); addKey - O(1); remove - O(1); contains - O(1)
// Space Complexity : O(K+M) - K is number of buckets and  M is number of bucket items
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyHashSet {
    
    int buckets;
    int bucketRange;
    boolean[][] storage;
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = 1000;
        bucketRange = 1000;
        storage = new boolean[buckets][];
    }
    
    private int getKey(int key){
        return key % buckets;
    }
    
    private int getBucketRange(int key){
        return key / bucketRange;
    }
    
    public void add(int key) {       
        int bucket = this.getKey(key);
        int bucketItem = this.getBucketRange(key);
        System.out.println("bucketItem:" + bucketItem);
        if (storage[bucket] == null){
           if (bucket == 0){
               storage[bucket] = new boolean[bucketRange+1]; 
           } 
            else {
                storage[bucket] = new boolean[bucketRange];
                System.out.println("here2");
            }
        }
        
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = this.getKey(key);
        int bucketItem = this.getBucketRange(key);
        if (storage[bucket]==null){
            return;
        }
        storage[bucket][bucketItem] = false;
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = this.getKey(key);
        int bucketItem = this.getBucketRange(key);
        if (storage[bucket]==null){
            return false;
        }
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

// Your code here along with comments explaining your approach

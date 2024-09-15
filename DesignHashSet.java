// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashSet {
    private int bucket =1000;
    private int bucketItem =1000;
    
    public int hashfuncBucket(int key){
        return key % bucket;
    }

    public int hashfuncBucketItem(int key){
        return key / bucketItem;
    }
    
    private boolean[][] hashset;
    /** Initialize your data structure here. */
    public MyHashSet() {
        hashset=new boolean[bucket][];
    }
    
    public void add(int key) {
        int bucketIndex=hashfuncBucket(key);
        int bucketItemIndex=hashfuncBucketItem(key);
        
        if(hashset[bucketIndex]==null){
            hashset[bucketIndex]=new boolean[bucketItem];
        }
        
        hashset[bucketIndex][bucketItemIndex]=true;
    }
    
    public void remove(int key) {
        int bucketIndex=hashfuncBucket(key);
        int bucketItemIndex=hashfuncBucketItem(key);
        
        if(hashset[bucketIndex]==null){
            return;
        }
        
        hashset[bucketIndex][bucketItemIndex]=false;
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketIndex=hashfuncBucket(key);
        int bucketItemIndex=hashfuncBucketItem(key);
        
        return hashset[bucketIndex] != null && hashset[bucketIndex][bucketItemIndex];
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
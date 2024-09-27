// Time Complexity : O(1)
// Space Complexity : O(n2) worst case
class MyHashSet {
    
    boolean hashSet[][];
    int bucket = 1000, bucketItem = 1001;
    
    int idxBucket(int key) { return Integer.hashCode(key)%bucket; }
    int idxBucketItem(int key) { return Integer.hashCode(key)/bucket; }

    /** Initialize your data structure here. */
    public MyHashSet() {
        hashSet = new boolean[bucket][];
    }
    
    public void add(int key) {
        int index = idxBucket(key);
        int indexBucketItem = idxBucketItem(key);
        if(hashSet[index] == null) hashSet[index] = new boolean[bucketItem];
        hashSet[index][indexBucketItem] = true;
    }
    
    public void remove(int key) {
        int index = idxBucket(key);
        if(hashSet[index] == null) return;
        int indexBucketItem = idxBucketItem(key);
        hashSet[index][indexBucketItem] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = idxBucket(key);
        if(hashSet[index] == null) return false;
        int indexBucketItem = idxBucketItem(key);
        return hashSet[index][indexBucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
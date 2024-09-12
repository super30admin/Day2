class MyHashSet {

    boolean[][] storage;
    int buckets;
    int bucketItems;
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets =1000;
        bucketItems=1000;
        storage = new boolean[buckets][];
    }
    
    private int getBucketIndex(int key){     
        return key%buckets;
    }
    
    private int getBucketItemsIndex(int key)
    {
        return key/bucketItems;
    }
        
    public void add(int key) {
        int bucketsIndex = getBucketIndex(key);
        int bucketItemsIndex = getBucketItemsIndex(key);
        if(storage[bucketsIndex]==null){
            if(bucketsIndex==0){
                storage[bucketsIndex] = new boolean[bucketItems+1];
            }else{
                storage[bucketsIndex]= new boolean[bucketItems];
            }
        }
         storage[bucketsIndex][bucketItemsIndex] =true;
    }
    
    public void remove(int key) {
        int bucketsIndex = getBucketIndex(key);
        int bucketItemsIndex = getBucketItemsIndex(key);
        if(storage[bucketsIndex]==null)return;
        storage[bucketsIndex][bucketItemsIndex] =false;
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
       int bucketsIndex = getBucketIndex(key);
        int bucketItemsIndex = getBucketItemsIndex(key);
        if(storage[bucketsIndex]==null) return false;
        return storage[bucketsIndex][bucketItemsIndex];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

//timecomplexity : O(1)
//spaceComplexity : O(n);
// Didnot ran successfully giving me wrong answer in test case even though I tried to submit the same solution explained in class :( Will look into it again. Please comment if there are mistakes in code
//approach: double hashing

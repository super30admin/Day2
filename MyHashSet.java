
/*Time Complexity : O(1)
 Space Complexity :O(N)
 Did this code successfully run on Leetcode : yes
 Any problem you faced while coding this : No
*/
/*
 * Here we are using Double hashing 
 * 
 */
class MyHashSet {
    boolean storage[][];
    int buckets;
    int bucketItems;
    public MyHashSet() {
        buckets =1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];  
    }
    
    int fetchBucket(int val){
        return val%buckets;
    }
    int fetchBucketItem(int val){
        return val/bucketItems;
    }
    
    public void add(int key) {
        int fetchBucket = fetchBucket(key);
        int fetchBucketItem = fetchBucketItem(key);
        if(storage[fetchBucket] == null){
            if(fetchBucket == 0){
                storage[fetchBucket] = new boolean[bucketItems+1];
            }else{
                 storage[fetchBucket] = new boolean[bucketItems]; 
            }
        }
        storage[fetchBucket][fetchBucketItem] = true;
    }
    
    public void remove(int key) {
        int fetchBucket = fetchBucket(key);
        int fetchBucketItem = fetchBucketItem(key);
        if(storage[fetchBucket] == null){
            return;
        }
        storage[fetchBucket][fetchBucketItem] = false;
        
    }
    
    public boolean contains(int key) {
        
        int fetchBucket = fetchBucket(key);
        int fetchBucketItem = fetchBucketItem(key);
        if(storage[fetchBucket] == null){
            return false;
        }
        else{
            return storage[fetchBucket][fetchBucketItem];
        }
        
    }
}


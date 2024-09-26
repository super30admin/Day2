// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes


public class MyHashSet {

    private boolean [][] storage;
    int noOfBuckets;
    int noOfBucketItems;
    
    public MyHashSet() {
        noOfBuckets = 1000;
        noOfBucketItems = 1000;
        storage = new boolean[noOfBuckets][];
    }
    
    private int assignBucket(int key) {
        return key % noOfBuckets;
    }
    
    private int assignBucketIndex(int key) {
        return key / noOfBucketItems;
    }
    
    public void add(int key) {
        int bucketNumber = assignBucket(key);
        int bucketItemIndex = assignBucketIndex(key);
        if(storage[bucketNumber] == null) 
        {
            if(bucketNumber == 0)
            {
                storage[bucketNumber] = new boolean[noOfBucketItems + 1];
            }
            else
            {
                storage[bucketNumber] = new boolean[noOfBucketItems];
            }
        }
        storage[bucketNumber][bucketItemIndex] = true;
    }
    
    public void remove(int key) {
        int bucketNumber = assignBucket(key);
        int bucketItemIndex = assignBucketIndex(key);
        if(storage[bucketNumber] == null) 
         {
             return;
         }
        storage[bucketNumber][bucketItemIndex] = false;
    }
    
    public boolean contains(int key) {
        int bucketNumber = assignBucket(key);
        int bucketItemIndex = assignBucketIndex(key);
        if(storage[bucketNumber] == null) 
         {
             return false;
         }
        return storage[bucketNumber][bucketItemIndex];
    }

    public static void main(String args[]) 
    { 
        MyHashSet obj = new MyHashSet();
        obj.add(3);
        obj.add(4);
        obj.add(5);
        obj.remove(4);
        boolean param_3 = obj.contains(4);
        System.out.println(param_3);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

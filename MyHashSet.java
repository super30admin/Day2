// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


public class MyHashSet {
    private boolean[][] storageBuckets;
    private int noOfBuckets;
    private int noOfBucketItems;

    /** Initialize your data structure here. */

    public MyHashSet() {
        //initialise the buckets
        noOfBuckets = 1000;
        noOfBucketItems = 1000;
        storageBuckets = new boolean[noOfBuckets][];

    }
    // Using double hashing technique
    //hash functions
    private int getBucketIndex(int key) {
        return key % 1000;
    }

    private int getBucketItemIndex(int key) {
        return key / 1000;
    }

    public void add(int key) {
        //get the bucket index primary and secondary array
        int bucketIndex = getBucketIndex(key);
        int bucketItemsIndex = getBucketItemIndex(key);
        //check the secondary array already exist, if not create one
        if(storageBuckets[bucketIndex]== null) {
            if(bucketIndex == 0) {
                storageBuckets[bucketIndex] = new boolean[noOfBucketItems + 1];
            } else {
                storageBuckets[bucketIndex] = new boolean[noOfBucketItems];
            }
        }

        storageBuckets[bucketIndex][bucketItemsIndex] = true;

    }

    public void remove(int key) {
        // get to hash code to access the element and remove it
        int bucketIndex = getBucketIndex(key);
        int bucketItemsIndex = getBucketItemIndex(key);
        if(storageBuckets[bucketIndex] == null) return;
        storageBuckets[bucketIndex][bucketItemsIndex] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        // get to hash code to access the element
        int bucketIndex = getBucketIndex(key);
        int bucketItemsIndex = getBucketItemIndex(key);
        if(storageBuckets[bucketIndex] == null) {
            return false;
        }
        return storageBuckets[bucketIndex][bucketItemsIndex];
    }
    public static void main(String[] args) {
        //Your MyHashSet object will be instantiated and called as such:
        MyHashSet obj = new MyHashSet();
        obj.add(5);
        obj.add(4);
        obj.remove(5);
        boolean param_3 = obj.contains(4);
        System.out.println("Contains key or not :" +param_3 );
    }
}

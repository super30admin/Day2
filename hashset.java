// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashSet {
    int buckets;
    int bucketItems;
    boolean[][] storage;

    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }

    private int getBucket(int key) {
        return key % buckets;
    }

    private int getBucketItem(int key) {
        return key / bucketItems;
    }

    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null) {
            if (bucket == 0) {
                //This is for the corner case, where if we have 10^6 as the key, we get bucketItem as 10^6/1000 = 1000,
                //but if we only declare 1000 (bucketItems) number of elements, the index will only be going from 0 to 999
                //which will give out an index out of bound exception, in order to avoid it we declare +1 index so that we can
                //accomidate the 10^6 use case.
                storage[bucket] = new boolean[bucketItems + 1];
            } else {
                storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null) {
            return;
        }
        storage[bucket][bucketItem] = false;
    }

    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null) {
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
/**
 Time Complexity: O(1) as we are using double hashing to reach to element while adding, removing or searching

 Space complexity: O(1) constant space for array allocation 1000 * 1000

 Approach: Here with help of double hashing we serach for index in boolean 2D array
 it is better to use boolean array as we already have key which is value and hashset only is used to see if value is present or not.

 For index 0 i.e bucket 0 we have to declare the bucketItems size as 10001 as we have the highest element as 1000 so to accomodate that but for rest bucket 1 .. 1000 we don't have that problem as it is out of given range
 */
class MyHashSet {
    boolean storage[][];
    int buckets;
    int bucketItems;

    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }

    public void add(int key) {
        int index = getBucket(key);

        if (storage[index] == null) {
            if (index == 0) {
                storage[index] = new boolean[1001];
            } else {
                storage[index] = new boolean[1000];
            }
        }

        int offset = getBucketItem(key);

        storage[index][offset] = true;
    }

    public void remove(int key) {
        int index = getBucket(key);

        if (storage[index] != null) {
            int offset = getBucketItem(key);
            storage[index][offset] = false;
        }
    }

    public boolean contains(int key) {
        int index = getBucket(key);

        if (storage[index] != null) {
            int offset = getBucketItem(key);
            return storage[index][offset];
        }

        return false;
    }

    private int getBucketItem(int key) {
        return key / 1000;
    }

    private int getBucket(int key) {
        return key % 1000;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

public class MyHashSet {
    /*
     * Time Complexity: O(1) for adding, removing and searching an element in HashSet
     * Space Complexity: A little sketchy on this. I feel this is O(n) as the fixed size of array for buckets (primary
     * array is given). Then O(log(n)) for secondary array in the best case. Can this be O(n(log(n)) considering in the
     * best case.
     * Author: Aditya Mulik
     */

    private boolean[][] storage;
    int buckets;
    int bucketItems;

    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][]; // Initialize primary array only
    }

    private int getBucket(int key) {
        return key % buckets;
    }

    private int getBucketItems(int key) {
        return key / bucketItems;
    }

    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);

        if (storage[bucket] == null) {

            if (bucket ==  0) {
                storage[bucket] = new boolean[bucketItems + 1]; // Handling edge case of inserting key of array size to avoid IndexOutOfBoundError
            } else {
                storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);

        if (storage[bucket] == null) {
            return;
        }

        storage[bucket][bucketItem] = false;
    }

    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);

        if (storage[bucket] == null) {
            return false;
        }

        return storage[bucket][bucketItem];
    }

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();

        hashSet.add(1);
        hashSet.add(2);
        hashSet.contains(1);
        hashSet.contains(3);
        hashSet.add(2);
        hashSet.contains(2);
        hashSet.remove(2);

        System.out.println(hashSet);
    }
}

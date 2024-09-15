// In this implementation I am creating a 2-d boolean array which indicates the bucket and the index in that bucket where element is present
// I have used hash functions to determine the bucket in which a element needs to be places and the index where the element needs to be placed in that bucket. 

// Time Complexity : O(1) for all operations 
// Space Complexity : 

public class MyHashSet2 {

    private boolean[][] storage;
    private int buckets;
    private int bucketItems;

    public MyHashSet2() {
        buckets = 1000;
        bucketItems = 1001;
        storage = new boolean[buckets][];
    }

    public void add(int key) {
        int bucket = key % buckets;
        int bucketItem = key / bucketItems;

        if (storage[bucket] == null) {
            storage[bucket] = new boolean[bucketItems];
        }
        storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = key % buckets;
        int bucketItem = key / bucketItems;

        if (storage[bucket] == null) {
            return;
        }
        storage[bucket][bucketItem] = false;
    }

    public boolean contains(int key) {
        int bucket = key % buckets;
        int bucketItem = key / bucketItems;
        if (storage[bucket] == null) {
            return false;
        }
        return storage[bucket][bucketItem];
    }

    public static void main(String[] args) {
        MyHashSet2 set2 = new MyHashSet2();
        set2.add(12);
        set2.add(25);
        set2.add(30);

        set2.remove(12);
        if (set2.contains(25)) {
            System.out.println("Element exist");
        } else {
            System.out.println("Element does not exist");
        }

        if (set2.contains(35)) {
            System.out.println("Element exist");
        } else {
            System.out.println("Element does not exist");
        }
    }
}

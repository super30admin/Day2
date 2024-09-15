
//Time Complexity: O(1)
//Space Complexity: O(N)
public class MyHashSet {
	boolean storage[][];

    int buckets;
    int bucketList;

    int calcBucket(int key)
    {
        return key % 1000;
    }

    int calcBucketList(int key) {
        return key / 1000;
    }

    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = 1000;
        bucketList = 1000;
        storage = new boolean[buckets][];
    }

    public void add(int key) {
        int bucketIndex = calcBucket(key);
        int bucketListIndex = calcBucketList(key);

        if(storage[bucketIndex] == null) {
            storage[bucketIndex] = new boolean[bucketList];
        }
        storage[bucketIndex][bucketListIndex] = true;
    }

    public void remove(int key) {
        int bucketIndex = calcBucket(key);
        int bucketListIndex = calcBucketList(key);

        if(storage[bucketIndex] == null) {
            return;
        }
        storage[bucketIndex][bucketListIndex] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketIndex = calcBucket(key);
        int bucketListIndex = calcBucketList(key);

        if(storage[bucketIndex] == null) {
            return false;
        }
        return storage[bucketIndex][bucketListIndex];
    }

public static void main(String[] args) {
	MyHashSet hs = new MyHashSet();
	hs.add(5);
	hs.add(8);
	hs.add(9);
	System.out.println(hs.contains(5));
}
}

//Time complexity: O(1) for all operations
//Space complexity: O(n)

class MyHashSet {

    int buckets = 1000;
    int bucketItems = 1000;

    boolean[][] hashset;

    int hashfunc1(int key) {
        return key % buckets;
    }

    int hashfunc2(int key) {
        return key / bucketItems;
    }

    /** Initialize your data structure here. */
    public MyHashSet() {
        hashset = new boolean[buckets][];
    }

    public void add(int key) {
        int index1 = hashfunc1(key);
        int index2 = hashfunc2(key);

        if (hashset[index1] == null) {
            hashset[index1] = new boolean[bucketItems];
        }
        hashset[index1][index2] = true;

    }

    public void remove(int key) {
        int index1 = hashfunc1(key);
        int index2 = hashfunc2(key);

        if (hashset[index1] == null) {
            return;
        }
        hashset[index1][index2] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index1 = hashfunc1(key);
        int index2 = hashfunc2(key);

        if (hashset[index1] == null) {
            return false;
        }
        return hashset[index1][index2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj
 * = new MyHashSet(); obj.add(key); obj.remove(key); boolean param_3 =
 * obj.contains(key);
 */
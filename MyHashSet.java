// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class MyHashSet {

    int bucketItems;
    boolean[][] bucketStore;

    /** Initialize your data structure here. */
    public MyHashSet() {
        bucketItems = 1000;
        bucketStore = new boolean[bucketItems + 1][];
    }

    public void add(int key) {
        int hashed_key = key % 1000;
        int hashed_key2 = key / 1000;

        if (bucketStore[hashed_key] == null) {
            bucketStore[hashed_key] = new boolean[hashed_key == 0 ? 1001 : 1000];
        }
        bucketStore[hashed_key][hashed_key2] = true;
    }

    public void remove(int key) {
        int hashed_key = key % 1000;
        int hashed_key2 = key / 1000;
        if (bucketStore[hashed_key] == null)
            return;
        bucketStore[hashed_key][hashed_key2] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hashed_key = key % 1000;
        int hashed_key2 = key / 1000;
        if (bucketStore[hashed_key] == null)
            return false;
        else
            return bucketStore[hashed_key][hashed_key2];
    }

    public static void main(String[] args) {
        MyHashSet hset = new MyHashSet();
        hset.add(22);
        hset.add(23);
        hset.add(44);
        hset.add(29);
        hset.add(777);
        hset.add(980);

        System.out.println(hset.contains(777));
        hset.remove(777);
        System.out.println(hset.contains(777));

    }
}

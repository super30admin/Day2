// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

//Basic DS under the hood is array. And We can do double hashing or linear chaining (LinkedList) to avoid collision.
// Using double hashing
class MyHashMapApproach1 {

    class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node[][] buckets;
    int bucketSize = 1000;
    int bucketItemsSize = 1000;

    public MyHashMapApproach1() {
        this.buckets = new Node[bucketSize][];

    }

    private int primaryHashFunction(int key) {
        return key % bucketSize;
    }

    private int secondaryHashFunction(int key) {
        return key / bucketItemsSize;
    }

    public void put(int key, int value) {
        int hash1 = primaryHashFunction(key);
        if (this.buckets[hash1] == null) {
            if (hash1 == 0) {
                this.buckets[hash1] = new Node[this.bucketItemsSize + 1];
            } else {
                this.buckets[hash1] = new Node[this.bucketItemsSize];
            }

        }

        int hash2 = secondaryHashFunction(key);
        this.buckets[hash1][hash2] = new Node(key, value);
    }

    public int get(int key) {
        int hash1 = primaryHashFunction(key);
        if (this.buckets[hash1] == null) {
            return -1;
        }

        int hash2 = secondaryHashFunction(key);
        if (this.buckets[hash1][hash2] == null) {
            return -1;
        }
        return this.buckets[hash1][hash2].value;
    }

    public void remove(int key) {
        int hash1 = primaryHashFunction(key);
        if (this.buckets[hash1] == null) {
            return;
        }

        int hash2 = secondaryHashFunction(key);
        this.buckets[hash1][hash2] = null;
    }
}
// Time Complexity : put() : O(N), get() : O(N), remove() : O(N), find() : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. Had to debug find() method

/**
 * Approach: Used seperate chaining collision resolution method. Initialized
 * Node array and used hash function.
 * Used the concept of dummy node (key: -1, value: -1). If the primary index is
 * null a dummy node is inserted
 */

class MyHashMap {

    int buckets;
    Node storage[];

    class Node {
        int key, value;
        Node next;
        Node dummyNode;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public MyHashMap() {
        this.buckets = 1000;
        this.storage = new Node[buckets];
    }

    int getBucket(int key) {
        return Integer.hashCode(key) % buckets;
    }

    // Common method to find the previous node
    private Node find(Node dummyNode, int key) {
        Node prev = dummyNode;
        Node curr = dummyNode.next;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int bucket = getBucket(key);
        if (storage[bucket] == null) {
            storage[bucket] = new Node(-1, -1); // Inserting a dummy node if bucket is not initialized
        }
        Node prev = find(storage[bucket], key);
        if (prev.next != null) {
            prev.next.value = value; // In case, key already exists value is overwritten
        } else {
            prev.next = new Node(key, value); // If case doesn't exist, add a new node
        }
    }

    public int get(int key) {
        int bucket = getBucket(key);
        if (storage[bucket] == null)
            return -1;
        Node prev = find(storage[bucket], key);
        if (prev.next != null)
            return prev.next.value;
        return -1;
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        if (storage[bucket] == null)
            return;
        Node prev = find(storage[bucket], key);
        if (prev.next != null)
            prev.next = prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
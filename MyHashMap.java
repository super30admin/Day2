class MyHashMap {
    // Did this code successfully run on Leetcode : YES
    // Any problem you faced while coding this : NO

    class Node {
        int key, value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // referenced buckets with Array of type Nodes (Linekdlists)
    Node[] buckets;
    int bucketSize;

    private int getHash(int key) {
        return Integer.hashCode(key) % bucketSize;
    }

    public MyHashMap() {
        bucketSize = 1000;
        buckets = new Node[bucketSize];

    }

    // finds the prev node. which helps in put, get and remove operations.
    private Node find(Node node, int key) {
        Node prev = node;
        Node curr = node.next;

        while (curr != null && prev.next.key != key) {
            prev = curr;
            curr = curr.next;

        }
        return prev;

    }
    // Time Complexity :O(1)
    // Space Complexity : O(n)

    public void put(int key, int value) {

        int index = getHash(key);
        // while inserting an element if there is no element in the bucket, add a dummy
        // node.
        if (buckets[index] == null) {
            buckets[index] = new Node(-1, -1);

        }

        Node prev = find(buckets[index], key);
        // if it is first node to be inserted or the last node with no key alreay
        // present in bucket.
        if (prev.next == null) {
            prev.next = new Node(key, value);
        }
        // if found the node with the same key, update the value.
        else {
            prev.next.value = value;
        }

    }

    // Time Complexity :O(1)
    // Space Complexity : O(n)
    public int get(int key) {
        int index = getHash(key);
        // if no nodes are present in the particular index of bucekts return -1.
        if (buckets[index] == null) {
            return -1;
        }
        Node prev = find(buckets[index], key);
        // if reached the end of the bucket while searching for the key, and key is not
        // present return -1
        if (prev.next == null) {
            return -1;
        }
        // if found the key return the value.
        else {
            return prev.next.value;
        }

    }

    // Time Complexity :O(1)
    // Space Complexity : O(n)
    public void remove(int key) {
        int index = getHash(key);
        // return if the bucket is empty with no nodes.
        if (buckets[index] == null) {
            return;
        }
        Node prev = find(buckets[index], key);
        // if reached end of the bucket searching all the keys and key is not found
        // return.
        if (prev.next == null) {
            return;
        }
        // if key to be removed is found, remove the key.
        else {
            prev.next = prev.next.next;
            return;
        }

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
 * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
 * obj.remove(key);
 */
class MyHashMap {

    // Node class for linked list structure in each bucket
    private class Node {
        int key, value;
        Node next; // Points to the next node in the list

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Array of buckets, each representing the head of a linked list
    private Node[] buckets;
    private final int SIZE = 1000; // Number of buckets for hashing

    // Constructor to initialize the HashMap
    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    // Hash function to get the index for a given key
    private int getBucketIndex(int key) {
        return Integer.hashCode(key) % SIZE; // Maps the key to a valid index
    }

    // Inserts a key-value pair into the HashMap
    public void put(int key, int value) {
        int index = getBucketIndex(key); // Find the bucket for the key
        Node head = buckets[index];

        if (head == null) {
            // If the bucket is empty, create a new node and assign it as the head
            buckets[index] = new Node(key, value);
            return;
        }

        // Traverse the linked list to check if the key exists
        Node prev = null, curr = head;
        while (curr != null) {
            if (curr.key == key) {
                curr.value = value; // Update value if key exists
                return;
            }
            prev = curr;
            curr = curr.next;
        }

        // If key does not exist, append a new node to the end of the list
        prev.next = new Node(key, value);
    }

    // Retrieves the value associated with the given key
    public int get(int key) {
        int index = getBucketIndex(key); // Find the bucket for the key
        Node curr = buckets[index];

        // Traverse the linked list to find the key
        while (curr != null) {
            if (curr.key == key) {
                return curr.value; // Return value if key is found
            }
            curr = curr.next;
        }

        return -1; // Return -1 if key is not found
    }

    // Removes the key-value pair for the given key
    public void remove(int key) {
        int index = getBucketIndex(key); // Find the bucket for the key
        Node curr = buckets[index];

        if (curr == null) return; // If bucket is empty, do nothing

        if (curr.key == key) {
            // If the key is at the head, update the head to the next node
            buckets[index] = curr.next;
            return;
        }

        // Traverse the list to find the key
        Node prev = null;
        while (curr != null) {
            if (curr.key == key) {
                prev.next = curr.next; // Remove the node by updating the link
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}

// Time Complexity :
// put()    - O(1) average, O(n) worst-case due to collision handling
// get()    - O(1) average, O(n) worst-case due to collision handling
// remove() - O(1) average, O(n) worst-case due to collision handling

// Space Complexity : O(n + SIZE)
// n is the number of key-value pairs, and SIZE is the number of buckets.

// Did this code successfully run on Leetcode : Yes

// Any problem you faced while coding this :
// No major issues, but while implementing the collision resolution
// using separate chaining, careful handling of edge cases
// (e.g., key at the head of the bucket) was required.

// Your code here along with comments explaining your approach

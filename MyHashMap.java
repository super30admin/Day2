// Time Complexity : O(n) where n is the size of linked list for all operations
// Space Complexity : O(n) where n is the size of linked list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Linear chaining technique to construct hashmap
class MyHashMap {
    // Inner class to represent each node in the linked list
    class Node {
        int key;
        int val;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node[] storage;
    private int size;

    public MyHashMap() {
        this.size = 10000;
        this.storage = new Node[size];
    }

    // Hash function to compute the index for a given key
    private int hashIdx(int key) {
        return key % size;
    }

    // Helper method to search for a node in a linked list
    private Node search(Node head, int key) {
        Node prev = head;
        Node curr = head.next;

        // Traverse the linked list to find the node with the given key
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = prev.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int index = hashIdx(key);

        // If the bucket is empty (no linked list), initialize it with a dummy node
        if (storage[index] == null) {
            storage[index] = new Node(-1, -1);
        }

        Node prev = search(storage[index], key);
        // If the key exists, update its value
        if (prev.next != null) {
            prev.next.val = value;
        } else {
            // If the key doesn't exist, create a new node and insert it at the end of the linked list
            prev.next = new Node(key, value);
        }
    }

    public int get(int key) {
        int index = hashIdx(key);

        if (storage[index] == null) {
            return -1;
        }

        Node prev = search(storage[index], key);
        if (prev.next == null) {
            return -1;
        }

        return prev.next.val;
    }

    public void remove(int key) {
        int index = hashIdx(key);

        if (storage[index] == null) {
            return;
        }

        Node prev = search(storage[index], key);
        if (prev.next == null) {
            return;
        }

        // Remove the node by skipping it in the linked list
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
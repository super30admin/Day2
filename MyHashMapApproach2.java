// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes had to go through the video once, got confused with prev and next

// Your code here along with comments explaining your approach

//Basic DS under the hood is array. And We can do double hashing or linear chaining (LinkedList) to avoid collision.
// Using Linear chaining

class MyHashMapApproach2 {

    class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    Node[] buckets;
    int bucketSize = 1000;

    public MyHashMapApproach2() {
        this.buckets = new Node[bucketSize];

    }

    private int primaryHashFunction(int key) {
        return key % bucketSize;
    }

    // Find the previous node where current is null or current.key is the key
    private Node findPrevNode(Node head, int key) {
        Node prev = null;
        Node curr = head;

        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int hash1 = primaryHashFunction(key);
        if (this.buckets[hash1] == null) {
            this.buckets[hash1] = new Node(-1, -1);
        }

        Node prev = findPrevNode(this.buckets[hash1], key);

        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }

    }

    public int get(int key) {
        int hash1 = primaryHashFunction(key);
        if (this.buckets[hash1] == null) {
            return -1;
        }

        Node prev = findPrevNode(this.buckets[hash1], key);

        if (prev.next == null)
            return -1;
        return prev.next.value;
    }

    public void remove(int key) {
        int hash1 = primaryHashFunction(key);
        if (this.buckets[hash1] == null) {
            return;
        }
        Node prev = findPrevNode(this.buckets[hash1], key);
        if (prev.next == null)
            return;
        Node curr = prev.next;
        prev.next = prev.next.next; // derefencing the current node and setting prev .next to prev.next.next
        curr.next= null;

    }
}
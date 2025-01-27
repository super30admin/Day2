// Time Complexity : O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

class MyHashMap {

    class Node {
        int val;
        int key;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node[] storage;
    private int bucketSize;

    public MyHashMap() {
        this.bucketSize = 10000;
        this.storage = new Node[bucketSize];
    }

    private Node searchPreviousNode(Node node, int key) {
        Node previous = node;
        Node current = node.next;
        while (current != null && current.key != key) {
            previous = current;
            current = current.next;
        }
        return previous;
    }

    private int hashIndex(int key) {

        return key % bucketSize;
    }

    public void put(int key, int value) {
        int hashIndex = hashIndex(key);
        if (storage[hashIndex] == null) {
            storage[hashIndex] = new Node(-1, -1);
        }
        Node previousNode = searchPreviousNode(storage[hashIndex], key);
        if (previousNode.next != null) {
            previousNode.next.val = value;
        } else {
            previousNode.next = new Node(key, value);
        }
    }

    public int get(int key) {
        int hashIndex = hashIndex(key);
        if (storage[hashIndex] == null)
            return -1;
        Node previousNode = searchPreviousNode(storage[hashIndex], key);
        if (previousNode.next == null) {
            return -1;
        } else {
            return previousNode.next.val;
        }
    }

    public void remove(int key) {
        int hashIndex = hashIndex(key);
        if (storage[hashIndex] == null)
            return;
        Node previousNode = searchPreviousNode(storage[hashIndex], key);
        Node temp = previousNode.next;
        temp.next = null;
        previousNode.next = previousNode.next.next;

    }

}

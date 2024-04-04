// Time Complexity : 0(1)
// Space Complexity : 0(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MyHashMap {
    Node[] storage; //Creating a primary bucket
    int bucket;

    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key; //Assigning key and value to the key and value in the node
            this.value = value;
        }
    }

    public MyHashMap() {
        this.bucket = 10000; //Assigning the bucket with size 10000
        this.storage = new Node[bucket];
    }

    public int primaryBucket(int key) {
        return key % bucket; //Primary hash function to identify the index in the primary bucket
    }

    public Node findPrev(Node head, int key) { //To find the previous node
        Node prev = null;
        Node curr = head;

        while (curr != null && curr.key != key) { //Loop iterates through the LinkedList to find the previous node
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int hash = primaryBucket(key); //Finds the index
        if (storage[hash] == null) {
            Node newNode = new Node(-1, -1); //Creates a new dummy node if the node is not created already
            storage[hash] = newNode;
        }
        Node prev = findPrev(storage[hash], key); //Finds the previous node
        if (prev.next == null) {
            prev.next = new Node(key, value); //Inserts a new node after the previous node if the key doesn't already exist
        } else {
            prev.next.value = value; //Updates the already existing node with a new value
        }
    }

    public int get(int key) {
        int hash = primaryBucket(key);
        if (storage[hash] == null) {
            return -1; //Returns -1 if the index of the primary bucket has no node created
        }
        Node prev = findPrev(storage[hash], key);
        if (prev.next == null) {
            return -1; //Returns -1 if the key-value pair doesn't exist
        } else {
            return prev.next.value; //If found, returns the value
        }
    }

    public void remove(int key) {
        int hash = primaryBucket(key);
        if (storage[hash] == null) {
            return; //Nothing is removed if the head is null
        }
        Node prev = findPrev(storage[hash], key);
        if (prev.next == null) {
            return; //Returns nothing if the key doesn't exist
        } else {
            Node curr = prev.next;
            prev.next = prev.next.next; //Prev.next is now prev.next.next
            curr = null; //Assigning the current node to null
        }
    }
}
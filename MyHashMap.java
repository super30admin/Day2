class MyHashMap {
    // Creating class to hold LinkedList Node
    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Creating Primary array: Where I have indexes
    Node nodes[];

    // Creating Bucket of size (10^4)
    int buckets;

    // Creating Hash Function to return index value
    private int getBucketIndex(int key) {
        return key % buckets;
    }

    public MyHashMap() {
        buckets = 10000; // Initializing
        nodes = new Node[buckets];
    }

    // Return Ndode
    private Node find(int key, Node head) {
        Node previous = head;
        Node current = head.next;
        while (current != null && current.key != key) {
            previous = current;
            current = current.next;
        }
        return previous;
    }

    public void put(int key, int value) {
        int index = getBucketIndex(key); // get bucket index
        if (nodes[index] == null) { // Checking if the node[index] is null we have to initialize linkedlist
            nodes[index] = new Node(-1, -1);
        }

        Node preNode = find(key, nodes[index]);
        if (preNode.next == null) { // Unable to find the node in the linkedlist
            preNode.next = new Node(key, value);
        } else {
            // We found the node, so just updating the value
            preNode.next.value = value;
        }
    }

    public int get(int key) {
        int index = getBucketIndex(key);
        if (nodes[index] == null) { // No LinkList present
            return -1;
        }

        Node previous = find(key, nodes[index]);
        // If previous.next is null, we reached to the last node and didn't find the node having key passed
        if (previous.next == null) {
            return -1;
        }
        return previous.next.value;
    }

    public void remove(int key) {
        int index = getBucketIndex(key);
        if (nodes[index] == null){
            return;
        }
        Node previous = find(key, nodes[index]);
        if(previous.next == null){
            return;
        } else {
            previous.next = previous.next.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
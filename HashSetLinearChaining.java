/*
    Time Complexity : This implementation maintains the O(1) average time complexity for operations
                       due to the hashing, similar to hash map.
    Space Complexity : Amortized Complexity for User Functions (add(), remove(), contains()): O(1)
                       Worst-Case Complexity for User Functions: O(m), where m is the number of elements in the set.
 */
class HashSetLinearChaining {

    class Node {
        int key;
        Node next;

        public Node(int key) {
            this.key = key;
        }
    }

    Node[] storage; // Primary array
    int primaryBucketSize;

    public HashSetLinearChaining() {
        // Initialize with the same primary bucket size as the hash map
        this.primaryBucketSize = 10000;
        this.storage = new Node[primaryBucketSize];
    }

    private int getPrimaryHash(int key) {
        return key % primaryBucketSize;
    }

    private Node getPrevNode(Node head, int key) {
        Node prev = null;
        Node curr = head;

        // Traverse the nodes to find the previous node
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }

        return prev;
    }

    public void add(int key) {
        int primaryIndex = getPrimaryHash(key);
        if (storage[primaryIndex] == null) {
            // Initialize the linked list with a dummy head node
            storage[primaryIndex] = new Node(-1);
        }

        Node prev = getPrevNode(storage[primaryIndex], key);

        // If the key does not exist, add it to the end of the list
        if (prev.next == null) {
            prev.next = new Node(key);
        }
    }

    public void remove(int key) {
        int primaryIndex = getPrimaryHash(key);
        if (storage[primaryIndex] == null) {
            // If the bucket is empty, do nothing
            return;
        }

        Node prev = getPrevNode(storage[primaryIndex], key);
        if (prev.next == null) {
            // Key not found in the set
            return;
        }

        // Remove the node
        Node curr = prev.next;
        prev.next = curr.next;
        curr.next = null;
    }

    public boolean contains(int key) {
        int primaryIndex = getPrimaryHash(key);
        if (storage[primaryIndex] == null) {
            // If the bucket is empty, the key is not present
            return false;
        }

        Node prev = getPrevNode(storage[primaryIndex], key);
        return prev.next != null; // Return true if the key is found
    }
}



// Time Complexity : O(n) for put, get and remove since they all need a search() call to iterate over list
// Space Complexity : O(n) where n is size of hashmap
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// maintain an array of linkedlists for storing the hashmap
// on first put, initialize the list with dummy root node, and then add/update node on each put iterating the list using search to find existing key
// on get/remove, check if key exists using search, and then return value or link previous to key's next node to delete
class MyHashMap {
    int buckets = 1000;
    Node[] storage;

    class Node {
        int key;
        int value;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.value = val;
        }
    }

    public MyHashMap() {
        storage = new Node[buckets];
    }

    public void put(int key, int value) {
        int bucket = key % buckets;
        if (storage[bucket] == null) {
            storage[bucket] = new Node(-1, -1);
            storage[bucket].next = new Node(key, value);
        } else {
            Node prev = search(storage[bucket], key);
            if (null == prev.next) {
                prev.next = new Node(key, value);
            } else {
                prev.next.value = value;
            }
        }
    }

    public int get(int key) {
        int bucket = key % buckets;
        if (storage[bucket] == null || storage[bucket].next == null) {
            return -1;
        }
        Node prev = search(storage[bucket], key);
        return (null == prev.next) ? -1 : prev.next.value;
    }

    public void remove(int key) {
        int bucket = key % buckets;
        if (storage[bucket] == null || storage[bucket].next == null) {
            return;
        }
        Node prev = search(storage[bucket], key);
        if (null != prev.next) {
            prev.next = prev.next.next;
        }
    }

    //returns previous node to the key node
    private Node search(Node root, int key) {
        Node current = root.next;
        Node previous = root; //root will always be dummy node
        while (current != null && current.key != key) {
            previous = current;
            current = current.next;
        }
        return previous;
    }
}


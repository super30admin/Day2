// Time Complexity: O(1) for Put, Get, Remove methods
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Your code here along with comments explaining your approach in three sentences only
/**
 * Approach: 
 * This problem is to design a HashMap without using any built-in hash table libraries. 
 * I implemented a hash map using an array of linked lists, where each list stores
 * key-value pairs in the bucket based on the hash of the key. 
 * The put() method inserts or updates key-value pairs, get() retrieves values,
 * and remove() deletes a key-value pair, all using linked list traversal to handle collisions. 
 */ 
class MyHashMap {
    // Node class to store key-value pairs
    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    // Number of buckets in the hash table
    int buckets;
    // Array to store the linked lists of nodes
    Node[] storage;

    // Hash function to calculate the index for a given key 
    int getBucket(int key) {
        return Integer.hashCode(key) % this.buckets;
    }

    // Helper function to find the previous node of the given key in the linked list
    private Node find(Node dummy, int key) {
        Node pre = dummy;
        Node curr = dummy.next;

        // Traverse the linked list to find the node with the given key
        while(curr != null && curr.key != key) {
            pre = curr;
            curr = curr.next;
        }
        return pre; // Return the previous node 
    }

    // Constructor to Initialize the hash map with a fixed number of buckets
    public MyHashMap() {
        this.buckets = 1000;
        storage = new Node[this.buckets];
    }
    
    // Method to insert or update a key-value pair in the hash map
    public void put(int key, int value) {
        // Calculate the index for the key
        int bucket = getBucket(key);

        // If the bucket is empty, create a dummy node to represent the head of the linked list
        if(storage[bucket] == null) {
            storage[bucket] = new Node(-1,-1);
        }

        // Find the previous node of the key in the linked list
        Node pre = find(storage[bucket], key);

        // If the key is found, update its value
        if(pre.next != null) {
            pre.next.value = value;
        } else {
            //If the key is not found, add a new node to the linked list
            pre.next = new Node(key, value);
        }
    }
    
    // Method to get the value to a given key
    public int get(int key) {

        // Calculate the index for the key
        int bucket = getBucket(key);

        // If the bucket is empty, return -1
        if(storage[bucket] == null) {
            return -1;
        }

        // Find the previous node of the key in the linked list
        Node pre = find(storage[bucket], key);

        // If the key is not found, return -1
        if(pre.next == null) {
            return -1;
        }

        // Return the value to the found key
        return pre.next.value;
    }
    
    // Method to remove a key and its value from the hash map
    public void remove(int key) {
        int bucket = getBucket(key);

        // If the bucket is empty, do nothing 
        if(storage[bucket] == null) {
            return;
        }

        // Find the previous node of the key in the linked list
        Node pre = find(storage[bucket], key);

        // If the key exists, remove the node by skipping it in the linked list
        if(pre.next != null) {
            pre.next = pre.next.next;
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
// Time Complexity : O(n) for all operations put, get, remove due to find function that is traversing through all nodes
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach:
class MyHashMap {
    // Implementing Hashmap using Array of linkedlist (seperate chaining)
    // Defining Node class with key value pair
    class Node {
        int key, value;
        Node next;

        // Constructor
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Declaring buckets and Node array
    int buckets;
    Node[] storage;

    // This function will return the hash equivalent of the key
    int getBuckets(int key) {
        /*
         * Using inbuilt hashCode function that will ensure uniform distribution.
         * Then performing the mod operation to make sure our hash is in the range(0 to
         * 999)
         */
        return Integer.hashCode(key) % this.buckets;
    }

    // Find function that will traverse through the linkedlist and return the
    // previous node
    private Node find(Node dummy, int key) {
        Node prev = dummy;
        Node curr = dummy.next;
        // Traverse till we reach the end of LL or till we find the matching key
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        // Return previous node
        return prev;
    }

    public MyHashMap() {
        // Initializing buckets and array of nodes
        this.buckets = 1000;
        this.storage = new Node[this.buckets];
    }

    public void put(int key, int value) {
        // Getting the hash equivalent
        int bucket = getBuckets(key);
        /*
         * If at that position we find null, add a dummy node(-1,-1) to handle the case
         * where we are trying to do something with the first node
         */
        if (storage[bucket] == null) {
            storage[bucket] = new Node(-1, -1);
        }
        // Call the find function to find the previous node
        Node prev = find(storage[bucket], key);
        // If previous.next is not null that means we found the matching key
        // In that case, update the old value with new value
        if (prev.next != null) {
            prev.next.value = value;
        }
        /*
         * If previous.next is null that means we are at end and we could not find
         * matching key. In that case, create a new node
         */
        else {
            prev.next = new Node(key, value);
        }
    }

    public int get(int key) {
        // Getting the hash equivalent
        int bucket = getBuckets(key);
        // If at that position we find null, that means key not found
        if (storage[bucket] == null) {
            return -1;
        }
        // Call the find function to find the previous node
        Node prev = find(storage[bucket], key);
        // If previous.next is not null that means we found the matching key
        // In that case, return the value
        if (prev.next != null) {
            return prev.next.value;
        } else {
            // Else key not found so return -1
            return -1;
        }
    }

    public void remove(int key) {
        // Getting the hash equivalent
        int bucket = getBuckets(key);
        // If at that position we find null, that means key not found, do nothing
        if (storage[bucket] == null) {
            return;
        }
        // Call the find function to find the previous node
        Node prev = find(storage[bucket], key);
        // If previous.next is not null that means we found the matching key
        // In that case, replace previous.next with previous.next.next
        if (prev.next != null) {
            prev.next = prev.next.next;
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
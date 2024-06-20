// Time Complexity : O(1) -  amortized as Flipping of stacks will not happen in O(N) times 
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :  Yes
// Any problem you faced while coding this : No


class MyQueue {
    // Two stacks to store the elements of the queue
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    // Constructor to initialize the two stacks
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    // Method to push an element to the end of the queue
    public void push(int x) {
        stack1.push(x);
    }
    
    // Method to remove the element from the front of the queue and return it
    public int pop() {
        // Ensure stack2 has the current front element
        peek();
        return stack2.pop();
    }
    
    // Method to get the front element of the queue
    public int peek() {
        // If stack2 is empty, transfer elements from stack1 to stack2
        if (stack2.empty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
    
    // Method to check if the queue is empty
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */



 // Time Complexity : O(1) -  Because at max 100 iterations will be done over inner linked list which is as good as constant
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :  Yes
// Any problem you faced while coding this : No



class MyHashMap {
    // Inner class to represent each node in the linked list
    class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    int size = 10000; // Size of the outer array (hash table)
    private Node[] buckets;

    // Constructor to initialize the buckets array
    public MyHashMap() {
        buckets = new Node[size];
    }

    // Hash function to compute the index for a given key
    private int hashIndex(int key) {
        return key % size;
    }

    // Helper function to find the previous node for a given key in the linked list
    private Node findIndex(Node head, int key) {
        Node prev = null;
        Node current = head;
        while (current != null && current.key != key) {
            prev = current;
            current = current.next;
        }
        return prev;
    }

    // Method to insert or update a key-value pair
    public void put(int key, int value) {
        int index = hashIndex(key);
        if (buckets[index] == null) {
            // Initialize a dummy head node for the linked list at this index
            buckets[index] = new Node(-1, -1);
        }

        Node prev = findIndex(buckets[index], key);
        if (prev.next == null) {
            // Key doesn't exist, insert new node
            prev.next = new Node(key, value);
        } else {
            // Key exists, update the value
            prev.next.value = value;
        }
    }

    // Method to get the value associated with a key
    public int get(int key) {
        int index = hashIndex(key);
        if (buckets[index] == null) return -1; // Key doesn't exist
        Node prev = findIndex(buckets[index], key);
        return prev.next == null ? -1 : prev.next.value;
    }

    // Method to remove a key-value pair
    public void remove(int key) {
        int index = hashIndex(key);
        if (buckets[index] == null) return; // Key doesn't exist
        Node prev = findIndex(buckets[index], key);
        if (prev.next != null) {
            // Remove the node by updating the pointers
            Node temp = prev.next;
            prev.next = prev.next.next;
            temp.next = null; // Help GC
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key, value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */


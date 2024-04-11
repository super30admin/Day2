//Problem 1 : https://leetcode.com/problems/implement-queue-using-stacks/description/
// Time Complexity : O(1) for all operations  
// Space Complexity : O(n) where n is the number of elements in the queue 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyQueue {

    Stack<Integer> inSt;
    Stack<Integer> outSt;

    public MyQueue() {
        this.inSt = new Stack<>();
        this.outSt = new Stack<>();
    }

    // Adds an element to the queue by pushing it onto the inSt stack.
    public void push(int x) {
        inSt.push(x);
    }

    /*
     * Removes and returns the front element of the queue.
     * It first calls peek() to ensure that outSt has the next element to be popped.
     * Then, it pops and returns the top element from outSt.
     */
    public int pop() {
        peek();
        return outSt.pop();
    }

    /*
     * Returns the front element of the queue without removing it.
     * If outSt is empty, it transfers all elements from inSt to outSt, effectively
     * reversing the order of elements so that the first element pushed into inSt
     * becomes the first element in outSt (and therefore the front of the queue).
     * It then returns the top element of outSt (the front of the queue).
     */
    public int peek() {
        if (outSt.isEmpty()) {
            while (!inSt.isEmpty()) {
                outSt.push(inSt.pop());
            }
        }
        return outSt.peek();
    }

    public boolean empty() {
        return inSt.isEmpty() && outSt.isEmpty();
    }

}

// Problem 2 : https://leetcode.com/problems/design-hashmap/description/
// Time Complexity : O(1) for all operations
// Space Complexity : O(n) where n is the number of elements in the hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class MyHashMap {
    Node[] storage;
    int buckets;

    class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        buckets = 10000;
        storage = new Node[buckets];
    }

    private int getHash(int key) {
        return key % buckets;
    }

    private Node findPrevious(Node head, int key) {
        Node prev = null;
        Node curr = head;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    /*
     * Takes a key-value pair and inserts it into the hashmap.
     * Computes the hash for the key to determine the bucket.
     * If the bucket is empty, it creates a dummy node (with key=-1, value=-1) to
     * act as the head of the linked list.
     * Finds the previous node of the node with the given key using findPrevious
     * method.
     * If the previous node's next is null, it creates a new node with the given key
     * and value.
     * If the previous node's next is not null, it updates the value of the existing
     * node with the given key.
     */
    public void put(int key, int value) {
        int index = getHash(key);
        if (storage[index] == null) {
            Node newNode = new Node(-1, -1);
            storage[index] = newNode;
        }
        Node prev = findPrevious(storage[index], key);
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }

    /*
     * Retrieves the value associated with the given key from the hashmap.
     * Computes the hash for the key to determine the bucket.
     * If the bucket is empty, it returns -1.
     * Finds the previous node of the node with the given key using findPrevious
     * method.
     * If the previous node's next is null, it returns -1.
     * Otherwise, it returns the value of the node with the given key.
     */
    public int get(int key) {
        int index = getHash(key);
        if (storage[index] == null) {
            return -1;
        }
        Node prev = findPrevious(storage[index], key);
        if (prev.next == null) {
            return -1;
        }
        return prev.next.value;
    }

    /*
     * Removes the key-value pair with the given key from the hashmap.
     * Computes the hash for the key to determine the bucket.
     * If the bucket is empty, it does nothing.
     * Finds the previous node of the node with the given key using findPrevious
     * method.
     * If the previous node's next is null, it does nothing.
     * Otherwise, it removes the node with the given key from the linked list by
     * adjusting the next pointers.
     */
    public void remove(int key) {
        int index = getHash(key);
        if (storage[index] == null) {
            return;
        }
        Node prev = findPrevious(storage[index], key);
        if (prev.next == null) {
            return;
        }
        Node curr = prev.next;
        prev.next = prev.next.next;
        curr.next = null;
    }
}

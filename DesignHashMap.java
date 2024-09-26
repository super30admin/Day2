// Time Complexity : O(1) as we have a small constant size possible for every LinkedList chain
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*
 * In this approach, Linear chaining hash addressing method is implemented to design the hashmap
 * I have taken a primary array of length 10000 on which we can have a linkedList initialized with maximum length of 100
 * We calculate the hash value when we want to find a key and look for the linked list on that index in primary array.
 * We update, find, or update the node in that linked list.
 */

class MyHashMap {
    
    class Node {
        int key;
        int val;
        Node next;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    private Node[] storage;

    public MyHashMap() {
        storage = new Node[10000];
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        if (storage[index] == null) {
            // Linked list not present, so element not there
            // create a new LinkedList and add the dummy node there
            Node newNode = new Node(-1, -1);
            storage[index] = newNode;
        }
        
        Node prevNode = find(storage[index], key);
        
        if (prevNode.next == null) {
            // we did not find the element
            prevNode.next = new Node(key, value);
        } else {
            // we found the value, update it.
            prevNode.next.val = value;
        }
    }
    
    public int get(int key) {
        int index = hash(key);
        if (storage[index] == null) {
            // Linked list not present, so element not there
            // create a new LinkedList and add the dummy node there
            return -1;
        }
        
        Node prevNode = find(storage[index], key);
        
        if (prevNode.next == null) {
            // we did not find the element
            return -1;
        } else {
            // we found the element
            return prevNode.next.val;
        }
    }
    
    public void remove(int key) {
        int index = hash(key);
        if (storage[index] == null) {
            // Linked list not present, so element not there
            // create a new LinkedList and add the dummy node there
            return;
        }
        
        Node prevNode = find(storage[index], key);
        
        if (prevNode.next == null) {
            // we did not find the element
            return;
        } else {
            // we found the element, remove the element
            prevNode.next = prevNode.next.next;
        }
    }
    
    private Node find(Node node, int key) {
        Node prev = null;
        Node cur = node;
        
        while (cur != null && cur.key != key) {
            prev = cur;
            cur = cur.next;
        }
        
        return prev;
    }
    
    private int hash(int key) {
        return key % 10000;
    }
}
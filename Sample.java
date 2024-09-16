import java.util.Stack;
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

//Q1
//Time complexity can be O(n) for worst ccase scenario and O(1) as average for pop
//Time complexity is O(1) for push
class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();

    }

    public void push(int x) {
        stack1.push(x);

    }

    public int pop() {

        if (!stack2.isEmpty()) {
            return stack2.pop();
        }

        if (!stack1.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }

        if (!stack1.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    public boolean empty() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return true;
        }

        return false;
    }
}

// Q2
// Time complexity is O(1) for all as linked list can be of max length 100 =>
// O(100) = constant
class MyHashMap {

    class Node {

        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;

        }
    }

    int buckets;
    Node[] nodes;
    int[] storage;

    public MyHashMap() {
        buckets = 10000;
        nodes = new Node[buckets];

    }

    private int getBucket(int key) {
        return key % buckets;

    }

    private Node find(Node head, int key) {

        Node prev = head;
        Node curr = head.next;

        while (curr != null && curr.key != key) {
            prev = prev.next;
            curr = curr.next;
        }

        return prev;

    }

    public void put(int key, int value) {

        int bucket = getBucket(key);

        if (nodes[bucket] == null) {
            nodes[bucket] = new Node(-1, -1);
        }

        Node prev = find(nodes[bucket], key);

        if (prev.next != null) {
            prev.next.value = value;
        } else {
            prev.next = new Node(key, value);
        }

    }

    public int get(int key) {

        int bucket = getBucket(key);
        if (nodes[bucket] == null) {
            return -1;
        }

        Node prev = find(nodes[bucket], key);
        if (prev.next != null) {
            return prev.next.value;
        } else {
            return -1;
        }

    }

    public void remove(int key) {

        int bucket = getBucket(key);
        if (nodes[bucket] == null) {
            return;
        }

        Node prev = find(nodes[bucket], key);
        if (prev.next != null) {
            prev.next = prev.next.next;
        } else {
            return;
        }

    }
}
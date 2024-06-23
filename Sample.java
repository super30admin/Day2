// Time Complexity : push and empty will be O(1) and pop and peek in worst case scenario will be O(n)
// Space Complexity : all operations it should be O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Implement Queue Using Stack
// First we will always push in in stack. 
// For pop operation first we will check if out stack is empty if it is empty then we will first we will push all the elements from in stack to out stack. 
// Then we will pop element from out stack. Same with empty function. We will peek from out stack and if it is empty we will move elements from in stack to out.
class MyQueue {

    private Stack<Integer> in;
    private Stack<Integer> out;

    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        // if (out.isEmpty()) {
        //     while(!in.isEmpty()) {
        //         out.push(in.pop());
        //     }
        // }
        // out.pop();
        peek();
        return out.pop();
    }
    
    public int peek() {
        if (out.isEmpty()) {
            while(!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
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


// Time Complexity : It will be O(n) for all the functions where n is length of linked list.
// Space Complexity : Space complexity will depend as we will initiate array of 10000 nodes and it will grow as we will add linked list at each array element.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I couldn't think of this approach for the first time. When explained in the class then only I was able to solve this.


// Your code here along with comments explaining your approach
// Design HashMap
// First will initiate the storage array with null nodes (-1, -1) if the list is not initiated at that place in storage. 
// Then we will find the place to insert the node in put method. If it is null for now then add the node otherwise just replace the value.
// In find function we will check if the current node is not null and key is not there which we needs to find then we will traverse through the tree. 
// Once we find the element we will exit the loop and return otherwise it will return null.
// Same with remove. First will call find method and if we find that element we will delete the link of 2 nodes.
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

    private Node [] storage;

    public MyHashMap() {
        this.storage = new Node[10000];
    }
    
    private int idx (int key) {
        return key%10000;
    }

    private Node find(Node head, int key) {
        Node prev = null;
        Node curr = head;

        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int idx = idx(key);
        if(storage[idx] == null) {
            storage[idx] = new Node(-1, -1);
        }
        Node prev = find(storage[idx], key);
        if(prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.val = value;
        }
    }
    
    public int get(int key) {
        int idx = idx(key);
        if(storage[idx] == null) return -1;
        Node prev = find(storage[idx], key);
        if(prev.next == null) return -1;
        return prev.next.val;
    }
    
    public void remove(int key) {
        int idx = idx(key);
        if (storage[idx] == null) return;
        Node prev = find(storage[idx], key);
        if(prev.next!=null) {
            Node temp = prev.next;
            prev.next = prev.next.next;
            temp.next = null;
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
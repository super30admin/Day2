// Time Complexity : O(1);
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//Queue wih 2 stacks

class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;

    public MyQueue() {
        this.st1 = new Stack<Integer>();
        this.st2 = new Stack<Integer>();
    }
    
    public void push(int x) {
       st1.push(x);
    }
    
    public int pop() {
        peek();
        return st2.pop();
    }
    
    public int peek() {
        if (st2.isEmpty()) {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }
        return st2.peek();
    }
    
    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
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

//hashmap

class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
        public Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    private Node[] stor;
    public MyHashMap() {
        this.stor = new Node[10000];
    }
    private int idx(int key){
        return key % 10000;
    }
    private Node find(Node head,int key){
        Node prev = null;
        Node curr = head;

        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;

        }
        return prev;
    }
    
    public void put(int key, int value) {
        int idx = idx(key);
        if(stor[idx]== null){
            stor[idx] = new Node(-1,-1);
        }
        Node prev =find(stor[idx],key);
        if(prev.next == null){
            prev.next = new Node(key,value);
        }else{
            prev.next.val = value;
        }
    }
    
    public int get(int key) {
        int idx = idx(key);
        if(stor[idx]==null) return -1;
        Node prev = find(stor[idx], key);
        if(prev.next == null) return -1;
        return prev.next.val ;
    }
    
    public void remove(int key) {
        int idx = idx(key);
        if(stor[idx]==null) return;
        Node prev = find(stor[idx], key);
        if(prev.next != null) {
            Node temp = prev.next;
            prev.next = prev.next.next;
        }
    }
    
}
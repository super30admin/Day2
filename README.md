# Design-2

Explain your approach in **three sentences only** at top of your code

class MyQueue {
       Stack<Integer> instack;
       Stack<Integer> outstack;
    public MyQueue() {
        instack = new Stack<>();
        outstack = new Stack<>();
        
    }
    
    public void push(int x) {
        instack.push(x);
    }
    
    public int pop() {
        peek();
        return outstack.pop();
    }
    
    public int peek() {
        if(outstack.isEmpty()){
            while(!instack.isEmpty()){
                outstack.push(instack.pop());
            }
        }
        return outstack.peek();
    }
    
    public boolean empty() {
        return instack.isEmpty() && outstack.isEmpty();
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
 
## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)




## Problem 2:
Design Hashmap (https://leetcode.com/problems/design-hashmap/)

class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
        public Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
    private Node [] storage;
    
    public MyHashMap() {
       this.storage = new Node[10000] ;
    }
    public Node search(Node head,int key){
         Node prev = head;
         Node curr = head.next;
         while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;

         }
         return prev;
    }
    private int hashIndex(int key){
        return key%10000;
    }
    public void put(int key, int value) {
       int idx = hashIndex(key);
        if(storage[idx]==null){
            storage[idx] = new Node(-1,-1);
        }
        Node prev = search(storage[idx],key);
            if(prev.next != null){
                prev.next.val = value;


            }
            else{
                prev.next =  new Node(key,value);
            }
        }
    
    
    public int get(int key) {
        int idx = hashIndex(key);
        if(storage[idx]==null) return -1;
        Node prev = search(storage[idx],key);
         if(prev.next == null){
            return -1;
         }else{
             return prev.next.val;
         }
    }
    
    public void remove(int key) {
        int idx = hashIndex(key);
        if(storage[idx]==null) return ;
        Node prev = search(storage[idx],key);
          if(prev.next == null) return ;
          Node temp = prev.next;
          prev.next = temp.next;
          temp.next = null;
    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */



//Problem 4 - Queue using Stack

// Time Complexity : O(n) push - O(1) pop-  O(1) 
// Space Complexity : O(n) where n is number of input
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach

class MyQueue {
   
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
       
        this.in = new Stack<>();
        this.out = new Stack<>();
       
    }
   
    public void push(int x) {
        in.push(x);        
    }
   
    public int pop() {
        peek();
        return out.pop();
       
    }
   
    public int peek() {
        if(out.isEmpty())
        {
            while(!in.isEmpty())
            {
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

Problem 5 - Design Hashmap
// Time Complexity : O(1)
// Space Complexity : O(n) where n is number of input
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class MyHashMap {
   
    class Node{
        int key;
        int val;
        Node next;  
       
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
   
    Node[] storage;
   
    private int hash(int key){
       
        return key%10000;
    }
   
    public MyHashMap() {
        this.storage = new Node[10000];
    }
   
    public Node find(Node node, int key){
       
        Node prev = null;
        Node curr = node;
       
        while(curr!=null && curr.key!=key)
        {
            prev = curr;
            curr = curr.next;
        }
       
        return prev;        
       
    }
   
    public void put(int key, int value) {
       
        int hash = hash(key);
        if(storage[hash] == null)
        {
            storage[hash] = new Node(-1, -1);
        }
       
        Node prev = find(storage[hash], key);
        if(prev.next==null)
        {
            prev.next = new Node(key, value);
        }
       
        else
        {
         prev.next.val = value;  
        }
    }
   
    public int get(int key) {
       
        int hash = hash(key);
        if(storage[hash]==null)
            return -1;
        Node prev = find(storage[hash], key);
        if(prev.next == null)
            return -1;
        return prev.next.val;
       
    }
   
    public void remove(int key) {
       
        int hash = hash(key);
        if(storage[hash] == null)
            return;
        Node prev = find(storage[hash],key);
        if(prev.next == null)
            return;
        prev.next = prev.next.next;
       
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

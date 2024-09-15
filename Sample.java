// Time Complexity : Amortized O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :Nope


// Your code here along with comments explaining your approach
//Design Queue using 2 stacks

class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MyQueue() {
        stack1=new Stack<Integer>();
        stack2=new Stack<Integer>();
        
        
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while((stack1.isEmpty()==false)){
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while(stack2.isEmpty()==false){
            stack1.push(stack2.pop());
        }
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack1.pop();
        
    }
    
    /** Get the front element. */
    public int peek() {
        return stack1.peek();
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
        
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


 //Design HashMap Efficieant code

 class MyHashMap {

    /** Initialize your data structure here. */
    
    class Node{
        int key,value;
        Node next;
        Node(int key,int value){
            this.key=key;
            this.value=value;
            
        }
    }
    int size=10000;
    
    Node nodes[]; 
    public MyHashMap() {
        nodes=new Node[size];
        
    }
    public int getKey(int key){
        return Integer.hashCode(key)%size;
    }
    public Node find(Node head,int key){
        Node prev=null;
        Node cur=head;
        while(cur!=null && cur.key!=key){
            prev=cur;
            cur=cur.next;
        }
        return prev;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index=getKey(key);
        if(nodes[index]==null){
            nodes[index]=new Node(-1,-1);
        }
        Node prev=find(nodes[index],key);
        if(prev.next==null){
            prev.next=new Node(key,value);
        }else{
            prev.next.value=value;
        }
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index=getKey(key);
        if(nodes[index]==null){
            return -1;

        }
        Node prev=find(nodes[index],key);
        if(prev.next==null){
            return -1;
        }
        else{
            return prev.next.value;
        }
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index=getKey(key);
        if(nodes[index]==null){
            return;
        }
        Node prev=find(nodes[index],key);
        if(prev.next==null){
            return;
        }
        prev.next=prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
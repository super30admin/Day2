// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


//Implement Queue using Stacks
//  Use 2 stacks. When peek and pop is called, transfer all elements from instack to outstack if 
// outStack is empty. Pop from outStack or return peek from outStack.

class MyQueue {

    Stack<Integer> inStack;
    Stack<Integer> outStack;
    
    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }
    
    public int peek() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        
        return outStack.peek();
    }
    
    public boolean empty() {
        return (inStack.isEmpty()&&outStack.isEmpty());
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



//Design HashMap using linear chaining.
// Use linear chaining when space is not a restriction or you don’t need // to consume contiguous memory.

class MyHashMap {
    
    public class Node {
        int key,val;
        Node next;
        
        Node(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }

    Node[] array;
    
    public int hash(int key) {
        return key%10000;
    }
    
    public MyHashMap() {
        array = new Node[10000];
    }
    
    public Node find(Node head,int key) {
        
        Node prev = head;
        Node curr = head.next;
        while(curr!=null && curr.key!=key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        if(array[index]==null){
            array[index] = new Node(-1,-1);
        }
        
        Node prev = find(array[index],key);
        if(prev.next==null)
        {
            prev.next = new Node(key,value);
            return;
        }
        
        prev.next.val = value;
        return;
    }
    
    public int get(int key) {
        int index = hash(key);
        if(array[index]==null)
            return -1;
        
        Node prev = find(array[index],key);
        if(prev.next==null)
            return -1;
        else
            return prev.next.val;
    }
    
    public void remove(int key) {
        int index = hash(key);
        if(array[index]==null)
            return ;
        
        Node prev = find(array[index],key);
        if(prev.next!=null)
            prev.next = prev.next.next;
        
        return;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

//Average Time complexity :- O(1)

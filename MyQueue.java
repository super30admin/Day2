// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None.



public class MyQueue {

    private int length;
    Node top, bottom;
    /** Initialize your data structure here. */
    public MyQueue() {
        length = 0;
        top = null;
        bottom = null;
    }

    class Node {
        int data;
        Node next;

        Node (int data) {
            this.data = data;
        }
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        Node new_node = new Node (x);

        if (empty()) {
            // Push new node on top if the stack is empty
            top = new_node;
        }

        else {
            // Push new node next from the bottom
            bottom.next = new_node;
        }

        bottom = new_node;
        length++; // length of the stack increases as  a new node is added
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (empty()) return -1;
        
        int val = top.data;
        top = top.next;
        length--;
        // Replace popped element with null 
        if(empty()) bottom  = null;

        return val;
    }
    
    /** Get the front element. */
    public int peek() {
        return top.data;                
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        boolean isEmpty;
        if(length == 0) isEmpty = true;
        else isEmpty = false;

        return isEmpty;
    }
}

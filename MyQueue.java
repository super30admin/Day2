package Day1;

import java.util.Stack;

class MyQueue {
    
    // Time Complexity: 
    // O(1) for push operations
    // O(n) for pop/peek operations if stack s2 is empty
    // O(1) for pop/peek operations if stack s2 is not empty

    // Space Complexity: O(n)
    // At worst case, only one of the stacks will hold all the elements of the queue.
    
    // Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
    
     // Implementing Queue using two stacks
     // Stack s1 stores elements such that latest inserted element in queue is at top of stack s1. Stack s1 is used for push operations.
     // Stack s2 stores elements in the reverse order of s1, i.e. latest inserted element in queue is at bottom of stack s2. Stack s2 is used for peek/pop operations.
    
    Stack<Integer> s1;
    Stack<Integer> s2;
    
    /** Initialize your data structure here. */
    // Constructor to initialize the two stacks
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    // Push the incoming element to stack s1.
    public void push(int x) {
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    // if s2 is empty:
    //      a) transfer all elements of s1->s2 to bring front of the queue at the top of s2.       //      b) Then delete the topmost element from s2.
    // else delete topmost element of s2 directly.
    public int pop() {
        
        int poppedElem = 0;
        
        if (this.empty()) {
            return 0;
        }
            
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                int temp = s1.pop();
                s2.push(temp);
            }  
        } 
        
        poppedElem = s2.pop();
        return poppedElem;
    }
    
    /** Get the front element. */
    // if s2 is empty:
    //      a) transfer all elements of s1->s2 to bring front of the queue at the top of s2.       //      b) Then peek the topmost element from s2.
    // else peek topmost element of s2 directly.
    public int peek() {
        
        int peekedElem = 0;
         
        if (this.empty()) {
            return 0;
        }
        
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                int temp = s1.pop();
                s2.push(temp);
            }  
        } 
        
        peekedElem = s2.peek();
        return peekedElem;
    }
    
    /** Returns whether the queue is empty. */
    // If both stacks s1 and s2 are empty => the queue is empty.
    public boolean empty() {
        if (s1.isEmpty() && s2.isEmpty()) {
            return true;
        }
        return false;
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
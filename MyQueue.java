/*
 * Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Example:

MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);  
queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false
Notes:

You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

 */

package com.s30.edu.design2;

import java.util.Stack;

class MyQueue {
    
	// Declaration of stack
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int front;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>(); // Initializing the stack
        stack2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    /*
     * Time Complexity: O (1)
     */
    public void push(int x) {
    	// Keep track of the front element when stack1 is empty
    	/*
    	 * We do this to handle the scenario of calling peek operation even before pushing the elements onto stack2 i.e; when stack2 is empty
    	 */
        if(stack1.isEmpty()){
            front = x;
        }
        stack1.push(x); // If stack not empty, then push the element
    }
    
    
    /** Removes the element from in front of queue and returns that element. */
    /*
     * Time Complexity: O (N) -> In the worst case we have empty whole of stack 1 into stack 2
     */
    public int pop() {
        int x;
        
        if (stack1.isEmpty() && stack2.isEmpty())
        { 
            System.out.println("Queue is empty"); 
            System.exit(0); 
        } 
        
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                x = stack1.pop();
                stack2.push(x);
            }
        }
        
        x = stack2.pop();
        return x;
               
    }
    
    /** Get the front element. */
    /*
     * Time Complexity: O (1)
     */
    public int peek() {
        
        if(!stack2.isEmpty()){
            return stack2.peek();
        }
        
        return front;
}   
    /** Returns whether the queue is empty. */
    /*
     * Time Complexity: O (1)
     */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
        
    }
    
    public static void main(String[] args){
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);  
        queue.peek();  // returns 1
        queue.pop();   // returns 1
        queue.empty(); // returns false
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

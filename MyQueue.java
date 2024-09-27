package com.company;

// Time Complexity :O(2N)
// Space Complexity :O(2N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;

public class MyQueue {
    Stack<Integer> stack = new Stack<>(); // Stack declaration
    public MyQueue() {
        
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x); // push the given element on to the stack which can be done in O(N) time
    }

    public int reverse(int x){ // Since stack is FIFO, created a temp stack to get the first element on the top
        Stack<Integer> temp = new Stack<>();
        if(x == 0){ // condition for the peek operation
            while(stack.empty() == false){
                temp.push(stack.pop());		// temp is filled with values from stack, the first element which was added to stack is on top, can be done in O(N) time
            }
            int topValue = temp.peek();		// peek is used to just get the value from the top of temp, i.e front of the queue
            while(temp.empty() == false){
                stack.push(temp.pop());		// temp stack element is now put back into the main stack to maintain the order of the push operation, can be done in O(N) time
            }
            return topValue;				// total time complexity O(N) + O(N) = O(2N)
        }

        if(x == -1){	// condition for the pop operation
            while(stack.empty() == false){ 	// temp is filled with values from stack, the first element which was added to stack is on top, can be done in O(N) time
                temp.push(stack.pop());
            }
            int topValue = temp.pop();		// pop is used to remove the value from the top of temp, i.e front of the queue
            while(temp.empty() == false){
                stack.push(temp.pop());		// temp stack element is now put back into the main stack to maintain the order of the push operation, can be done in O(N-1) time
            }
            return topValue;				// total time complexity O(N) + O(N-1) = O(2N)
        }
        return -1;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return reverse(-1);					// reverse function is called with the argument as -1 to indicate pop operation 
    }

    /** Get the front element. */
    public int peek() {
        return reverse(0);					// reverse function is called with the argument as 0 to indicate peep operation 
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stack.empty()){					// checks if the stack is empty or not using the standard operation of stack. Takes O(1) time
            return true;
        }
        return false;
    }
}

package com.hmoework;

import java.util.Stack;

public class MyQueue {

	Stack<Integer> incomingStack;
	Stack<Integer> outgoingStack;
    /** Initialize your data structure here. */
    public MyQueue() {
    	incomingStack = new Stack<>();
    	outgoingStack = new Stack<>();
    	
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    	if(outgoingStack.isEmpty()) {
    		incomingStack.push(x);
    	} else {
    		 while(!outgoingStack.isEmpty()) {
    	        	int popElement = outgoingStack.pop();
    	        	incomingStack.push(popElement);
    	        }
    		 incomingStack.push(x);
    	}
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	int pop = -1;
        while(!incomingStack.isEmpty()) {
        	int popElement = incomingStack.pop();
        	outgoingStack.push(popElement);
        }
        if(!outgoingStack.isEmpty()) {
        	pop = outgoingStack.pop();
        }
        return pop;
    }
    
    /** Get the front element. */
    public int peek() {
    	int peek = -1;
        while(!incomingStack.isEmpty()) {
        	int peekElement = incomingStack.pop();
        	outgoingStack.push(peekElement);
        }
        if(!outgoingStack.isEmpty()) {
        	return outgoingStack.peek();
        }
        return peek;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (incomingStack.isEmpty() && outgoingStack.isEmpty());
    }
}

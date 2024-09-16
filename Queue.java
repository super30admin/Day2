package com.hashmap;

import java.util.Stack;

public class Queue {

	public static void main(String[] args) {
		

	}

	
	 private Stack<Integer> st1 = new Stack<>();
	 private Stack<Integer> st2 = new Stack<>();
	    /** Initialize your data structure here. */
	    public Queue() {
	        
	    }
	    
	    /** Push element x to the back of queue. */
	    public void push(int x) {
	        st1.push(x);
	        
	    }
	    
	    /** Removes the element from in front of queue and returns that element. */
	    public int pop() {
	        if(st2.isEmpty()){
	            while(!st1.isEmpty()){
	                st2.push(st1.pop());
	            }
	        }
	        return st2.pop();
	        
	    }
	    
	    /** Get the front element. */
	    public int peek() {
	        if(st2.isEmpty()){
	         while(!st1.isEmpty()){
	            st2.push(st1.pop());
	            
	          }
	        }
	        return st2.peek();
	        
	    }
	    
	    /** Returns whether the queue is empty. */
	    public boolean empty() {
	        return st1.isEmpty() && st2.isEmpty();
	    }
}

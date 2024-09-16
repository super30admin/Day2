package Queue_using_Stack;

import java.util.Stack;

public class Queue_Stack {
	
	static class MyQueue {

	    Stack <Integer> inStack = new Stack<>(); // In Stack
	    Stack <Integer> outStack = new Stack<>(); //Out Stack
	    /** Initialize your data structure here. */
	    public MyQueue() {
	       
	        
	        
	    }
	    
	    /** Push element x to the back of queue. */
	    public void push(int x) {
	        inStack.push(x);
	        
	    }
	    
	    /** Removes the element from in front of queue and returns that element. */
	    public int pop() {
	 // If out stack is empty push all elements from Instack to Outstack       
	        if(outStack.isEmpty())
	        {
	            while(!inStack.isEmpty())
	            {
	                outStack.push(inStack.pop());
	            }
	                
	        }
	        
	        return outStack.pop();
	        
	    }
	    
	    /** Get the front element. */
	    public int peek() {
	        
	        if(outStack.isEmpty())
	        {
	            while(!inStack.isEmpty())
	            {
	                outStack.push(inStack.pop());
	            }
	                
	        }
	        return outStack.peek();
	    }
	    
	    /** Returns whether the queue is empty. */
	    public boolean empty() {
	        return inStack.isEmpty()&& outStack.isEmpty();
	    }
	}


	public static void main(String[] args) {

		MyQueue obj = new MyQueue();  
	   obj.push(1);
       obj.push(10); 
       obj.push(20);
        System.out.println(obj.pop());  
	    System.out.println(obj.pop()); 
	    System.out.println("After removing first 2 values");
	    System.out.println(obj.empty());
	    System.out.println(obj.peek()); 
	    System.out.println(obj.pop());
	    System.out.println("After removing last value");
	    System.out.println(obj.empty());
		
	}

}

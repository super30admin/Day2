
import java.util.*;

public class MyQueue {
	
	public Stack<Integer> stack1 = new Stack<Integer>();
	public Stack<Integer> stack2 = new Stack<Integer>();
	
	 /** Initialize your data structure here. */
    public MyQueue() {
    	
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack2.isEmpty()) {
        	while(stack1.isEmpty() != true) {
        		int temp = stack1.pop();
        		stack2.push(temp);
        	}
        }
    
        int front = stack2.pop();
        return front;
    }
    
    /** Get the front element. */
    public int peek() {
        if(stack2.isEmpty()) {
        	while(stack1.isEmpty() != true) {
        		int temp = stack1.pop();
        		stack2.push(temp);
        	}
        }
        return stack2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
    	if(stack1.isEmpty() && stack2.isEmpty()) {
    		return true;
    	}
        return false;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("hello");
	}

}
//edited

//Time Complexity : O(1) for push operation and for peek and pop it may be O(n) in certain 
// cases and O(1) in most cases.
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
/* Approach: Will be using two stacks for the implementation. Stack 1 will be used for pushing 
 * the new elements in the queue. Stack 2 will be used for pop and peek operations.
 * For getting the elements in FIFO fashion, the elements will be pushed from Stack 1 to Stack 2
 * if Stack 2 is empty.
 */

import java.util.*;

class MyQueue {
	
	Stack<Integer> stack1;
	Stack<Integer> stack2;
	
	/*
	 * Initializing the data structure
	 */
	public MyQueue() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
		
	}
	
	/*
	 * Push element x to the back of queue.
	 */
	public void push(int x) {
		stack1.push(x);
	}
	
	/*
	 * put all values from stack1 to stack2 if stack2 is empty
	 */
	public void stackInsert() {
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
	}
	
	/*
	 * Removes the element from in front of queue and returns that element. 
	 */
    public int pop() {
    	if(stack2.isEmpty()) {
    		stackInsert();
    	}
    	return stack2.pop();
        
    }
    
    /*
     * Get the front element. 
     */
    public int peek() {
    	if(stack2.isEmpty())
    		stackInsert();
    	return stack2.peek();
    }
    
    /*
     * Returns whether the queue is empty. 
     */
    public boolean empty() {
    	return stack1.isEmpty() && stack2.isEmpty();
    }
    
    public static void main(String[] args) {
    	MyQueue q = new MyQueue();
    	int val;
    	q.push(1);
    	q.push(2);
    	q.push(3);
    	q.push(4);
    	val = q.pop();
    	System.out.println("val:"+val);
    	val = q.peek();
    	System.out.println("val:"+val);
    	q.push(5);
    	val = q.pop();
    	System.out.println("val:"+val);
    }
}






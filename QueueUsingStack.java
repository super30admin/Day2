// Time Complexity :
// Push & Empty: O(1); Pop & Peek: Amortized O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;

public class QueueUsingStack {
	
	private Stack<Integer> pushSt;
	private Stack<Integer> popSt;
	
	/** Initialize your data structure here. */
	public QueueUsingStack() {
		pushSt = new Stack<>();
		popSt = new Stack<>();
	}
	
	/** Push element x to the back of queue. */
    public void push(int x) {
        pushSt.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //refill pop stack is empty
    	if(this.empty()) return Integer.MIN_VALUE;
    	
    	if(popSt.isEmpty()) {
    		while(!pushSt.isEmpty()) {
    			popSt.push(pushSt.pop());
    		}
    	}
    	return popSt.pop();
    }
    
    /** Get the front element. */
    public int peek() {
    	//refill pop stack is empty
    	if(this.empty()) return Integer.MIN_VALUE;
    	
    	if(popSt.isEmpty()) {
    		while(!pushSt.isEmpty()) {
    			popSt.push(pushSt.pop());
    		}
    	}
    	return popSt.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return pushSt.isEmpty() && popSt.isEmpty();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingStack myQ = new QueueUsingStack();
		myQ.push(1);
		myQ.push(2);
		
		System.out.println(myQ.peek());
		System.out.println(myQ.pop());
		System.out.println(myQ.empty());

	}

}

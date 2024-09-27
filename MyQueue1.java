import java.util.*;

// Time Complexity :  O(N) for push O(1) for all other operations 

// Space Complexity : O(N) for storing stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
  For Queue using Stack,we makes switching between stack duiring push opertation
*/

public class MyQueue1 {

	private Stack<Integer> stack1;
	private Stack<Integer> stack2;

	public MyQueue1() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		while (!stack1.isEmpty()) {
			stack2.push(stack1.peek());
			stack1.pop();
		}
		stack1.push(x);
		while (!stack2.isEmpty()) {
			stack1.push(stack2.peek());
			stack2.pop();
		}
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		return stack1.pop();
	}

	/** Get the front element. */
	public int peek() {
		return stack1.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return stack1.isEmpty();
	}
}
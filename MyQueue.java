
// Time Complexity :  push-O(N) pop- O(1) empty- O(1)  peek()- O(1)
// Space Complexity :  push-O(N) pop- O(1) empty- O(1)  peek()- O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.Stack;

class MyQueue {

	/** Initialize your data structure here. */
	// Declaring 2 stacks here
	Stack<Integer> stack1;
	Stack<Integer> stack2;

	public MyQueue() {
		// Initializing 2 stacks here
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		stack1.push(x); // Pushing elements onto the first stack
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		/*
		 * First checking if stack2 is empty, then push all elements present in stack1
		 * into stack 2. And finally if stack2 is still empty, then return -1 or if not
		 * empty then pop the top most element in stack2
		 */
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return !stack2.isEmpty() ? stack2.pop() : -1;
	}

	/** Get the front element. */
	public int peek() {
		/*
		 * First checking if stack2 is empty, then push all elements present in stack1
		 * into stack 2. And finally if stack2 is still empty, then return -1 or if not
		 * empty then return the top most element in stack2
		 */
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return !stack2.isEmpty() ? stack2.peek() : -1;
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		// If both stack1 and stack2 is empty then return true, else false
		return stack1.isEmpty() && stack2.isEmpty();
	}
}
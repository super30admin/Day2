// Time Complexity : Push -> O(1) worst case, Pop -> O(n) worst case
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

package queue;

import java.util.Stack;

public class MyQueue {
	Stack<Integer> stack1;
	Stack<Integer> stack2;
	int front;

	/** Initialize your data structure here. */
	public MyQueue() {
		// Use 2 stacks to mimic queue operations
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
		front = Integer.MAX_VALUE;
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		// Push element ot stack 1.
		if (stack1.empty()) {
			front = x;
		}
		stack1.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		// Empty stack1 and push all elements to stack2 (in reverse order)
		// Return top of stack 2.
		if (stack2.empty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		int val = stack2.pop();
		if(stack2.isEmpty()) {
			front = Integer.MAX_VALUE;
		}
		return val;
	}

	/** Get the front element. */
	public int peek() {
		// If stack 2 is empty, return front. Else, return top of stack 1.
		if (!stack2.isEmpty()) {
			return stack2.peek();
		}
		return front;
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}

	public static void main(String[] args) {
		MyQueue obj = new MyQueue();
		obj.push(1);
		System.out.println("obj.peek() = " + obj.peek());
		obj.push(2);
		obj.push(3);
		obj.push(4);
		obj.push(5);
		System.out.println("obj.pop() = " + obj.pop());
		System.out.println("obj.peek() = " + obj.peek());
		System.out.println("obj.empty() = " + obj.empty());
	}
}

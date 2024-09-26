// Time Complexity : O(n) for push, O(1) for pop,peek,isEmpty
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/**
 * 1. Define a two stacks .
 * 2. on push pop all elements from original to temp stack and push new element to temp stack. pop all the elements from temp and push into original stack.
 * 3. Remaining functions are standard stack functions on original stack. 
 *  
 */

import java.util.Stack;

class MyQueue {

	Stack<Integer> original;
	Stack<Integer> temp;

	/** Initialize your data structure here. */
	public MyQueue() {
		original = new Stack<>();
		temp = new Stack<>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		original.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		popAllToTemp();
		return temp.pop();
	}

	private void popAllToTemp() {
		if(temp.isEmpty()) {
			while(!original.isEmpty()) {
				temp.push(original.pop());
			}
		}
	}

	/** Get the front element. */
	public int peek() {
		popAllToTemp();
		return temp.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return original.isEmpty()&&temp.isEmpty();
	}
}

public class QueueWithStack {
	public static void main(String[] args) {
		MyQueue obj = new MyQueue();
		obj.push(10);
		obj.push(20);
		System.out.println(obj.peek());
		System.out.println( obj.pop());
		System.out.println(obj.peek());
		System.out.println( obj.pop());
		System.out.println(obj.empty());

	}
}

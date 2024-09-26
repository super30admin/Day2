package nov172020;

import java.util.Stack;

public class queueusingStack232 {
	/** Initialize your data structure here. */
	Stack<Integer> in;
	Stack<Integer> out;

	public queueusingStack232() {
		in = new Stack<>();
		out = new Stack<>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		in.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		peek();
		return out.pop();
	}

	/** Get the front element. */
	public int peek() {
		if (out.isEmpty()) {
			while (!in.isEmpty()) {
				out.push(in.pop());
			}

		}
		return out.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return in.isEmpty() && out.isEmpty();
	}

}
// Time Complexity
// Push O(1)
// Pop O(1)
//  peek O(1)
// Empty O(1)

/*
*/

import java.util.Stack;

public class MyQueue {
	Stack<Integer> inSt;
	Stack<Integer> outSt;

	/** Initialize your data structure here. */
	public MyQueue() {
		inSt = new Stack<Integer>();
		outSt = new Stack<Integer>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		inSt.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		if (outSt.isEmpty()) {
			while (!inSt.isEmpty()) {
				outSt.push(inSt.pop());
			}
		}

		return outSt.pop();

	}

	/** Get the front element. */
	public int peek() {
		if (outSt.isEmpty()) {
			while (!inSt.isEmpty()) {
				outSt.push(inSt.pop());
			}
		}
		return outSt.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return inSt.isEmpty() && outSt.isEmpty();
	}
}

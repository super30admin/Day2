// Time Complexity : 
//push: O(n)
//pop: O(1)
//peek: O(1)
//empty: O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.Stack;

public class MyQueue {

	Stack<Integer> mainStack;
	Stack<Integer> tempStack;
	
	public MyQueue() {
		mainStack = new Stack<Integer>();
		tempStack = new Stack<Integer>();
	}
	public void push(int x) {
		
		while(!mainStack.isEmpty()) {
			tempStack.push(mainStack.pop());
		}
		
		mainStack.push(x);
		
		while(!tempStack.isEmpty())
			mainStack.push(tempStack.pop());
	}
	
	public int pop() {
		return mainStack.pop();
	}
	
	public int peek() {
		return mainStack.peek();
	}
	
	public boolean empty() {
		return mainStack.isEmpty();
	}
}

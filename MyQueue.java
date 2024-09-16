package Day_2;

//Time Complexity : Insertion O(1), Deletion and Peek - O(n), Empty O(1)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :

/*
 * Your code here along with comments explaining your approach : 
 * I have implemented Queue using two stack. Elements are pushed in 'in' stack.
 * For pop operation, elements from in stack are copied in second and then pop is done.
 */

import java.util.Stack;

public class MyQueue {
	Stack<Integer> in;
	Stack<Integer> out;

	public MyQueue() {
		in = new Stack<>();
		out = new Stack<>();
	}

	public void push(int x) {
		in.push(x);
	}

	public int pop() {
		if (out.isEmpty()) {
			while (!in.isEmpty()) {
				out.push(in.pop());
			}
		}
		return out.pop();
	}

	public int peek() {
		if (out.isEmpty()) {
			while (!in.isEmpty()) {
				out.push(in.pop());
			}
		}
		return out.peek();
	}

	public boolean empty() {
		return in.isEmpty() && out.isEmpty();
	}

	public static void main(String[] args) {
		MyQueue obj = new MyQueue();
		obj.push(10);
		obj.push(4);
		int param_2 = obj.pop();
		int param_3 = obj.peek();
		boolean param_4 = obj.empty();
		System.out.println(param_2);
		System.out.println(param_3);
		System.out.println(param_4);
	}
}

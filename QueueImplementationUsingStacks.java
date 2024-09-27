package com.BigN;

import java.util.Stack;

public class QueueImplementation {

	/** Initialize your data structure here. */
	Stack<Integer> in = new Stack<>();
	Stack<Integer> out = new Stack<Integer>();

	public QueueImplementation() {

	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		in.push(x);
		/*
		 * if(out.isEmpty()) { out.push(in.pop()); }
		 */
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		// mistake --> till when to pop in??????????? till the in stack is empty!!
		if (out.isEmpty()) {
			while (!in.isEmpty()) {
				out.push(in.pop());
			}
		}
		return out.pop();
	}

	/** Get the front element. */
	public int peek() {
		if (out.isEmpty()) {
			while (!in.isEmpty()) {
				out.push(in.pop());
			}
		}
		System.out.println(out.peek());
		return out.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		if (in.isEmpty() && out.isEmpty()) {
			return true;
		} else
			return false;
	}

	public static void main(String args[]) {
		QueueImplementation queueImplementation = new QueueImplementation();

		queueImplementation.push(1);
		queueImplementation.push(2);
		queueImplementation.peek(); // returns 1
		queueImplementation.pop(); // returns 1
		queueImplementation.empty(); // returns false
	}
}
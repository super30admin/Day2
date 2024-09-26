package com.Aug2020;

import java.util.Stack;
//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this :

//how to make the solution work using one-stack only to avoid extra stack.
class MyQueue {

    Stack<Integer> st;
	Stack<Integer> st2;
    int val;
    /** Initialize your data structure here. */
    public MyQueue() {
        st = new Stack<Integer>();
		st2 = new Stack<Integer>();
        val = 0;
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if (st.empty()) {
            val = x;
        }
        st.push(x);
      
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (st2.empty()) {
              while (!st.empty() ) {

			        st2.push(st.pop());
		        } 
        }
     
        return st2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (!st2.empty()) 	   {
            return st2.peek();
        }
		return val;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st.isEmpty() && st2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.push(1);
		queue.push(2);
		queue.peek(); // returns 1

		queue.pop(); // returns 1
		queue.empty(); // returns false
	}

}

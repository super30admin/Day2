package Design2;
//Time Complexity : O(1) for all operations
//Space Complexity : O(n) space worst case
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

import java.util.Stack;

//Your code here along with comments explaining your approach

public class ImplementQueueUsingStack {


	   private Stack<Integer> s1;
	    private Stack<Integer> s2;

	    /** Initialize your data structure here. */
	    public ImplementQueueUsingStack() {
	    	s1  = new Stack<>();
	    	s2  = new Stack<>(); 	
	    }

	    public void push(int x) {
	    	//push all elements into s1
	        s1.push(x);
	    }

	    public int pop() {
	        // pop element from s2 and return it
	    	peek();
	        return s2.pop();

	    }

	    public int peek() {

	        if (!s2.isEmpty()) {
	            return s2.peek();
	        } else {
	            while (!s1.isEmpty())
	                s2.push(s1.pop());
	        }
	        return s2.peek();
	    }

	    public boolean empty() {

	        return s1.empty() && s2.empty();

	    }
}
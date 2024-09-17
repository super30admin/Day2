//Time Complexity : O(1)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : I, earlier, implemented this problem in different way which was not optimal solution.


import java.util.Stack;

class MinStack {
	Stack<Integer> S1;
	Stack<Integer> minStack;
	int min;
    /** initialize your data structure here. */
    public MinStack() {
    	S1 = new Stack<>();
    	minStack = new Stack<>();
    	minStack.push(min = Integer.MAX_VALUE);
    }
    
    public void push(int x) {
        min = Math.min(min, x);
        minStack.push(min);
        S1.push(x);
    }
    
    public void pop() {
        S1.pop();
        minStack.pop();
        min = minStack.peek();
    }
    
    public int top() {
        return S1.peek();
    }
    
    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
		MinStack MS = new MinStack();
		MS.push(10);
		MS.push(5);
		MS.push(25);
		MS.push(15);
		MS.push(1);
		System.out.println(MS.getMin());
		MS.pop();
		System.out.println(MS.top());
		System.out.println(MS.getMin());
		MS.pop();
		System.out.println(MS.getMin());
    }
}
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

import java.util.Stack;

class MinStack {

    int min;
    Stack<Integer> myStack;

    public MinStack() {
        this.myStack = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (val <= min) {
            myStack.push(min);
            min = val;
        }
        myStack.push(val);
    }

    public void pop() {
        if (min == myStack.pop()) {
            min = myStack.pop();
        }
    }

    public int top() {
        return myStack.peek();
    }

    public int getMin() {
        return min;
    }
}

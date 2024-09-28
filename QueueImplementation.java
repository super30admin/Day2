// Time Complexity : O(1) even when we perform pop and peek amortized cost remains O(1)
// Space Complexity : O(n) - we use 2 auxilary stacks
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


import java.util.Stack;

class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        while (stack1.size() > 1) {
            stack2.push(stack1.pop());
        }
        int val = stack1.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return val;
    }
    
    public int peek() {
        while (stack1.size() > 1) {
            stack2.push(stack1.pop());
        }
        int val = stack1.peek();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return val;
    }
    
    public boolean empty() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return true;
        }
        return false;
    }
}
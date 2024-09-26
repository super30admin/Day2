// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;

class MyQueue {

    private Stack<Integer> inStack; // push new elements in inStack
    private Stack<Integer> outStack; // pop elements from outStack
    
    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }
    
    private void transfer() {
        if (outStack.isEmpty()) {
            while(!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        transfer();
        return outStack.pop();
    }
    
    public int peek() {
        transfer();
        if (!outStack.isEmpty()) {
            return outStack.peek();
        }
        return -1;
    }
    
    public boolean empty() {
        return (inStack.isEmpty() && outStack.isEmpty());
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
// Time Complexity :for push and empty O(1) and for peek and pop Amortized O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class QueueUsingStack {

    Stack<Integer> inStack, outStack;
    
    public QueueUsingStack() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    
    public void transfer() {
        if(outStack.isEmpty()) {
            while(!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
    
    public int pop() {
        transfer();
        return outStack.pop();
    }
    
    public int peek() {
        transfer();
        return outStack.peek();
    }
    
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}

/**
 * Your QueueUsingStack object will be instantiated and called as such:
 * QueueUsingStack obj = new QueueUsingStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
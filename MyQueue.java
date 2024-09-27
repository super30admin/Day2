// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

import java.util.Stack;

class MyQueue {
    private Stack<Integer> mainStack;
    private Stack<Integer> auxillaryStack;

    public MyQueue() {
        mainStack = new Stack<>();
        auxillaryStack = new Stack<>();
    }
    
    public void push(int x) {
        while(!mainStack.empty()){
            auxillaryStack.push(mainStack.pop());
        }
        mainStack.push(x);
        while(!auxillaryStack.empty()){
            mainStack.push(auxillaryStack.pop());
        }
    }
    
    public int pop() {
        return mainStack.pop();
    }
    
    public int peek() {
        return mainStack.peek();
    }
    
    public boolean empty() {
        return mainStack.empty();
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
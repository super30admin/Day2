// Time Complexity : Push is O(1), Pop is O(1) on average 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.Stack;

class QueueStackSolution {
    //1st is in stack which is normal Stack
    //2nd is out stack which is used for FIFO pop
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public QueueStackSolution() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }
    
    public void push(int x) {
        //I will push all the elements as normal to in stack.
        inStack.push(x);
    }
    
    public int pop() {
        //While popping if will check if out stack is empty.
        //If empty I will transfer all the elements of in stack to out stack for FIFO pop operations. 
        if(outStack.isEmpty()) {
            while(!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }
    
    public int peek() {
        //Same logic as pop instaed of pop I will be performing peek operation.
        if(outStack.isEmpty()) {
            while(!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }
    
    public boolean empty() {
        //I will check for both stacks to return true.
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
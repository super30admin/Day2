// TC: O(1)
// SC: O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.Stack;

public class MyQueue {

    // Push only to the instack and pop from the outstack. 
    // Transfer all elements from the instack to outstack, when outstack is empty
    
    Stack<Integer>inStack;
    Stack<Integer>outStack;

    public MyQueue() {
        
        inStack=new Stack<>();
        outStack=new Stack<>();
    }
    
    public void push(int x) {
        
        inStack.push(x);
    }
    
    public int pop() {
       
        peek();
        return outStack.pop();
        
    }
    
    public int peek() {
        if(outStack.isEmpty())
        {
            while(!inStack.isEmpty())
                outStack.push(inStack.pop());
        }
        return outStack.peek();
    }
    
    public boolean empty() {
        
        return inStack.isEmpty() && outStack.isEmpty();
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
package design2;

import java.util.Stack;

//Time Complexity : O(n) for push, O(1) for pop
//Space Complexity : O(n) for push
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No, just needed some logic
public class ImplementQueueUsingStacks {
	Stack<Integer> stack1;
    Stack<Integer> stack2;
    public ImplementQueueUsingStacks() {
        stack1= new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        if(stack1.isEmpty())
            stack1.push(x);
        else {
            while(!stack1.isEmpty())
                stack2.push(stack1.pop());
            stack1.push(x);
            while(!stack2.isEmpty())
                stack1.push(stack2.pop());
        }
    }
    
    public int pop() {
        return stack1.pop();
    }
    
    public int peek() {
        return stack1.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty();
    }
}

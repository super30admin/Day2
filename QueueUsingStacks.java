/*
Time Complexity :
push : O(1)
pop : O(1)
peek : O(1)
empty : O(1)
Space Complexity : O(n)
Did this code successfully run on Leetcode : yes
*/ 
import java.util.Stack;

class MyQueue {
    private Stack<Integer> stack_in;
    private Stack<Integer> stack_out;
    public MyQueue() {
        stack_in = new Stack<Integer>();
        stack_out = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack_in.push(x);
    }
    
    public int pop() {
        if(stack_out.isEmpty()) {
            while(!stack_in.isEmpty()) {
                stack_out.push(stack_in.pop());
            }
        }
        return stack_out.pop();
    }
    
    public int peek() {
        if(stack_out.isEmpty()) {
            while(!stack_in.isEmpty()) {
                stack_out.push(stack_in.pop());
            }
        }
        return stack_out.peek();
    }
    
    public boolean empty() {
        return stack_in.isEmpty() && stack_out.isEmpty();
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
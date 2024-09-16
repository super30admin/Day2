// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.Stack;

class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private int top;
    public MyQueue() { //constructor
        stack1= new Stack<Integer>();
        stack2= new Stack<Integer>();
        top=0;
    }
    
    public void push(int x) {
        if(stack1.empty()){
            top=x;
        }
        //empty all existing contents of stack1, push them to stack2, 
        //hence last element in stack1 is now first element in stack2
        while(! stack1.empty()){
            stack2.push(stack1.pop());
        }
        //push new element to top of stack2
        stack2.push(x);
        //push back all the elements of stack2 to stack1, hence the first element in queue will always be on top of stack1
        //this allows us to get FIFO, as we can just pop the top element of stack2
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
    }
    
    public int pop() {
        int x=stack1.pop();
        if (!stack1.empty())
        top = stack1.peek();
        return x;
    }
    
    public int peek() {
        return top;
    }
    
    public boolean empty() {
        return stack1.isEmpty();
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
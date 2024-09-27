// Time Complexity : Push- O(1), Pop- Worst case O(n), Peek - Worst case O(n)  
// Space Complexity : O(n)       
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;
class MyQueue {
    //maintain two stacks
    Stack<Integer> in_stack;
    Stack<Integer> out_stack;
    
    public MyQueue() {
        in_stack=new Stack<>();
        out_stack=new Stack<>();
    }
    
    public void push(int x) {
        //always push the elements in instack
        in_stack.push(x);
    }
    
    public int pop() {
        //first peek the top element then pop from outstack
        peek();
        return out_stack.pop();
    }
    
    public int peek() {
        //if outstack is empty then push elements from instack to out stack 
        //to get the first element of the queue
        if(out_stack.isEmpty()){
            while(!in_stack.isEmpty()){
                out_stack.push(in_stack.pop());
            }
        }
        return out_stack.peek();
    }
    
    public boolean empty() {
        //check if both the stacks are empty
        return in_stack.isEmpty() && out_stack.isEmpty();
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
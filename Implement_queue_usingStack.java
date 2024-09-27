  
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> in_stack;
    Stack<Integer> out_stack;
    public MyQueue() {
        in_stack=new Stack<Integer>();
        out_stack=new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        in_stack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!out_stack.isEmpty())
            return out_stack.pop();
        else{
            while(!in_stack.isEmpty())
            {
                out_stack.push(in_stack.pop());
            }
            return out_stack.pop();
        }
        
    }
    
    /** Get the front element. */
    public int peek() {
        if(!out_stack.isEmpty())
            return out_stack.peek();
        else{
            while(!in_stack.isEmpty())
            {
                out_stack.push(in_stack.pop());
            }
            return out_stack.peek();
        }
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
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

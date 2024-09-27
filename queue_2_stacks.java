// Time Complexity : O(1) for push and amortized O(1) for pop
// Space Complexity : O(N) for push and O(1) for pop
// Did this code successfully run on Leetcode : Yes

class MyQueue {
    
    private Stack<Integer> in_stack = new Stack<Integer>();
    private Stack<Integer> out_stack = new Stack<Integer>();
    
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        in_stack.push(x);    
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return out_stack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(out_stack.isEmpty()){
            while(!in_stack.isEmpty())
                out_stack.push(in_stack.pop());
        }
        return out_stack.peek();
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
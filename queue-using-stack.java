// Time Complexity : O(1) for Push ,O(1) for pop ,O(1) for peek
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes, submitted and successfully passed all the test cases
// Any problem you faced while coding this : Was okay for the most parts.

class MyQueue {
    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();
    int front;
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(in.isEmpty())
        {
            front = x;
        }
        in.push(x);    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(out.isEmpty())
        {
            while(!in.isEmpty())
            {
                out.push(in.pop());
            }
        }
        return out.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(!out.isEmpty())
        {
            return out.peek();
        }
        return front;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
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
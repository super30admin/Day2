import java.util.Stack;

// Time Complexity : For Push: O(1), For Pop: If outStack is empty: O(n) and if it is not empty: O(1), For Peek: If OutStack is empty: O(n), if it is not empty: O(1)), For Empty: O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class MyQueue {
    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(out.isEmpty()){
            while (!in.isEmpty())
            {
                out.push(in.pop());
            }
        }
        return out.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(out.isEmpty()){
             while(!in.isEmpty())
             {
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}

// Time Complexity : Everything O(1), except pop which is almost O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


// https://leetcode.com/problems/implement-queue-using-stacks/

import java.util.Stack;

public class QueueUsingStacks {

    
    // Thought Process:
    /**
        2 Stacks, 1 in, 1 out
        
        Stack is FILO and Queue is FIFO
        So, push is same, but pop is reversed. So 2 stacks.
        
        new element pushed to 'in' stack
        element popped or peeked from 'out' stack
        
        pop or peek called, check if 'out' is empty, then move all 'in' to 'out'
    
    **/
    
    Stack<Integer> in;
    Stack<Integer> out;
    

    /** Initialize your data structure here. */
    public QueueUsingStacks() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return out.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return out.isEmpty() && in.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * QueueUsingStacks obj = new QueueUsingStacks();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */


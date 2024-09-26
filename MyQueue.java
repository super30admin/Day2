// Time Complexity : Only when out stack is empty, time complexity would be O(n) required to transfer all elements from in stack to out stack. So, amortized time complexity would be O(1) for all operations.
// Space Complexity : O(1) as we use no extra space, both the stacks together constitute the queue. 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

import java.util.*;

class MyQueue {

    Stack<Integer> in, out;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>(); 
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        //push to in stack
        in.push(x); 
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //if out is empty, transfer the elements from in stack to out stack
        if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }
        //remove element from out stack since the element in out stack are already reversed
        return out.pop(); 
    }
    
    /** Get the front element. */
    public int peek() {
        //if out is empty, transfer the elements from in stack to out stack
        if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }
        //remove element from out stack since the element in out stack are already reversed
        return out.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        //both stacks make up the queue. 
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
// Time Complexity : push - O(n); pop - O(1); peek - O(1); empty - O(1);
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;

class MyQueue {
    Stack<Integer> Stack1;
    Stack<Integer> Stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
        Stack1 = new Stack<>();
        Stack2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!(Stack1.isEmpty()))
        {
            Stack2.push(Stack1.pop());
        }
        
        Stack1.push(x);
        
        while(!(Stack2.isEmpty()))
        {
            Stack1.push(Stack2.pop());
        }        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return Stack1.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return Stack1.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return Stack1.isEmpty();        
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
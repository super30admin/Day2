// 232. Implement Queue using Stacks - https://leetcode.com/problems/implement-queue-using-stacks/
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No. After solving MinStack understood the concept of inbuilt stack operations


import java.util.Stack;

class MyQueue {
    // Queue -  First In First Out
/** Initialize your data structure here. */
Stack<Integer> stack, rstack;

public MyQueue() {
    stack = new Stack<Integer>();
    rstack = new Stack<Integer>(); // store reverse of stack values
}

/** Push element x to the back of queue. */
public void push(int x) {
    stack.push(x);
}

/** Removes the element from in front of queue and returns that element. */
public int pop() {
    if(empty())
    {
    return -1;
    }
    if(rstack.isEmpty())
    {
        while(!stack.isEmpty())
        {
            rstack.push(stack.pop());
        }
    }
    return rstack.pop();
}

/** Get the front element. */
public int peek() {
    if(empty())
    {
    return -1;
    }
    if(rstack.isEmpty())
    {
        while(!stack.isEmpty())
        {
            rstack.push(stack.pop());
        }
    }
    return rstack.peek();
    
}

/** Returns whether the queue is empty. */
public boolean empty() {
    if(stack.isEmpty() && rstack.isEmpty())
    {
        return true;
    }
    return false;
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
// Time Complexity : 
push - O(1)
pop - O(n)
peek - O(n)

// Space Complexity : O(n + n) = O(n)

// Did this code successfully run on Leetcode : yes

// Any problem you faced while coding this :

## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)


// Your code here along with comments explaining your approach
class MyQueue {

    Stack<Integer> pushStack;
    Stack<Integer> popAndPeek;
        
    /** Initialize your data structure here. */
    public MyQueue() {
        pushStack = new Stack<Integer>();
        popAndPeek = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        pushStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (popAndPeek.empty()) {
             while (!pushStack.empty()) {
                popAndPeek.push(pushStack.pop());
             }
        }
        return popAndPeek.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (popAndPeek.empty()) {
             while (!pushStack.empty()) {
                popAndPeek.push(pushStack.pop());
             }
        }
        return popAndPeek.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return popAndPeek.isEmpty() && pushStack.isEmpty();
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

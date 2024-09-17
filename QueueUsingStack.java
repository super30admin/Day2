// Time Complexity : O(1) amortized
// Space Complexity : O(n) where n is element in stock
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : First used Java iterator which return at randon


// Your code here along with comments explaining your approach
// add elements to stack1. peek or pop from stack2 if stack2 is empty, reload one by one from stack 1.

class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack2.isEmpty()) reload();
        return stack2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(stack2.isEmpty()) reload();
        return stack2.peek();
    }
    void reload(){
        while (!stack1.isEmpty()) {
           stack2.push(stack1.pop());
        }
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

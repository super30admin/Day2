// Time Complexity: O(1) is the armotized cost, but worst case would be O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * MyQueue class implements a queue using two stacks.
 * This implementation ensures that the first element added (FIFO order) 
 * is the first one to be removed, despite stacks following a 
 * Last-In-First-Out (LIFO) order.
 */
class MyQueue {
    Stack <Integer> pushStack;
    Stack <Integer> popStack;

    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();    
    }
    
    public void push(int x) {
        pushStack.push(x);
    }
    
    public int pop() {
        peek();
        return popStack.pop();
    }
    
    public int peek() {
        if (popStack.isEmpty()){
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }
    
    public boolean empty() {
        return popStack.isEmpty() && pushStack.isEmpty();
    }
}
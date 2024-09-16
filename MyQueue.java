// Time Complexity : O(n) since the stacks need swapped
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.Stack;

public class MyQueue {

    Stack<Integer> pushStack;
    Stack<Integer> popStack;


    /** Initialize your data structure here. */
    public MyQueue() {
        pushStack = new Stack();
        popStack = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        pushStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        moveElements(pushStack, popStack);
        return popStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        moveElements(pushStack, popStack);
        return popStack.peek();
    }

    private void moveElements(Stack<Integer> pushStack, Stack<Integer> popStack) {
        if(popStack.isEmpty()) {
            while(!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
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
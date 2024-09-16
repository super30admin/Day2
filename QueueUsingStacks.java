//Time complexity - push - O(1)
// pop and peek - O(n)
// Works on leetcode

import java.util.Stack;

class MyQueue {

    /** Initialize your data structure here. */
    private Stack<Integer> pushStack;
    private Stack<Integer> popAndTopStack;

    public MyQueue() {
        pushStack = new Stack();
        popAndTopStack = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        pushStack.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(this.empty()){
            return Integer.MAX_VALUE;
        }
        if(popAndTopStack.isEmpty()){
            while(!pushStack.isEmpty()){
                popAndTopStack.push(pushStack.pop());
            }
        }
        return popAndTopStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(this.empty()){
            return Integer.MAX_VALUE;
        }
        if(popAndTopStack.isEmpty()){
            while(!pushStack.isEmpty()){
                popAndTopStack.push(pushStack.pop());
            }
        }
        return popAndTopStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return pushStack.isEmpty() && popAndTopStack.isEmpty();
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

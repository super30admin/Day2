// Time Complexity : Push - O(1), Pop - Amortized O(1), Peek - O(1), isEmpty - O(1)
// Space Complexity : O(n) where n is the size of the stack currently
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.Stack;

public class MyQueue {

    /** Initialize your data structure here. */
    int size;
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MyQueue() {
        size=0;
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
        size++;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int popped = stack2.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        size--;
        return popped;
    }

    /** Get the front element. */
    public int peek() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int peeked = stack2.pop();
        stack1.push(peeked);
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return peeked;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (size==0)?true:false;
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
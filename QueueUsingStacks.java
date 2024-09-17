package S30.Design_2;


// Time Complexity : Push: O(1), Pop: Amortized O(1), Peek: Amortized O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.Stack;

public class QueueUsingStacks {

    Stack<Integer> stack1;
    Stack<Integer> stack2;
    /** Initialize your data structure here. */
    public QueueUsingStacks() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {

        if(empty()) return -1;
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()) stack2.push(stack1.pop());

        }
        return stack2.pop();

    }

    /** Get the front element. */
    public int peek() {
        if(empty()) return -1;
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()) stack2.push(stack1.pop());

        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

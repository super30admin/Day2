// Time Complexity : O(1) for push, peek, empty in all cases, O(1) for pop in average case, O(n) for pop in worst case
// Space Complexity : O(n) where n is size of queue
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// at pop/peek, if outstack is empty then moving all elements from instack to outstack,
// and then popping/peeking from outstack

import java.util.Stack;

class MyQueue {
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty() && !inStack.isEmpty()) {
            moveElementsFromInToOut();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty() && !inStack.isEmpty()) {
            moveElementsFromInToOut();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return (inStack.isEmpty() && outStack.isEmpty());
    }

    private void moveElementsFromInToOut() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}

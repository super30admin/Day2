// Time Complexity : O(1) Amortised - as discussed in class
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
class MyQueue {

    Stack<Integer> pushStack;
    Stack<Integer> PopandTopStack;

    /** Initialize your data structure here. */
    public MyQueue() {

        pushStack = new Stack<>();
        PopandTopStack = new Stack<>();

    }

    /** Push element x to the back of queue. */
    public void push(int x) {

        pushStack.push(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {

        if (this.empty()) {
            return -1;
        }

        if (PopandTopStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                PopandTopStack.push(pushStack.pop());
            }
        }

        return PopandTopStack.pop();

    }

    /** Get the front element. */
    public int peek() {
        if (this.empty()) {
            return -1;
        }

        if (PopandTopStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                PopandTopStack.push(pushStack.pop());
            }
        }

        return PopandTopStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {

        if (pushStack.isEmpty() && PopandTopStack.isEmpty()) {
            return true;
        }

        return false;

    }
}
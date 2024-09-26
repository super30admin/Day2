// Time Complexity : O(1) for all operations
// Space Complexity : O(N) - N is the number of push operations
// Did this code successfully run on Leetcode : YES
// LC submission link: https://leetcode.com/submissions/detail/526289916/
// Any problem you faced while coding this : No issues


class MyQueue {

    Stack<Integer> inStack;
    Stack<Integer> outStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int result = -1;

        if(!outStack.empty()) {
            result = outStack.pop();
        } else if (!inStack.empty()){
            while(!inStack.empty()) {
                outStack.push(inStack.pop());
            }

            result = outStack.pop();
        }

        return result;
    }

    /** Get the front element. */
    public int peek() {
        int result = -1;

        if(!outStack.empty()) {
            result = outStack.peek();
        } else if (!inStack.empty()){
            while(!inStack.empty()) {
                outStack.push(inStack.pop());
            }
            result = outStack.peek();
        }

        return result;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.empty() && outStack.empty();
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

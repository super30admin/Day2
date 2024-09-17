// Time Complexity : O(1)
// Space Complexity : O(n); n = total no of elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyQueue {

    Stack<Integer> in;
    Stack<Integer> out;
    /** Initialize your data structure here. */
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    /** Push element x to the back of queue. */
    //Time Complexity: O(1)
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    //Time Complexity: Amortized O(1)
    public int pop() {
        if (!out.isEmpty()) return out.pop();

        while (!in.isEmpty()) {
            out.push(in.pop());
        }

        return out.pop();
    }

    /** Get the front element. */
    //Time Complexity: Amortized O(1)
    public int peek() {
        if (!out.isEmpty()) return out.peek();

        while (!in.isEmpty()) {
            out.push(in.pop());
        }

        return out.peek();
    }

    /** Returns whether the queue is empty. */
    //Time Complexity: O(1)
    public boolean empty() {
        return stack.isEmpty() && helper.isEmpty();
    }
}

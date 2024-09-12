// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
class MyQueue {
    // Declaring the stacks
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        // pushing the key to the first stack.
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // poping the first stack and pushing the elements to the second stack
        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        // poping the second stack to get the FIFO order.
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        // if the elements have already been pushed to the second stack, peek from the second stack.
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        // if there are no elements in s2 then pop the first stack and push the elements to the second stack.
        else {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        // peek from the second element.
        return s2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        // if both the stacks are empty then queue is empty.
        return s1.isEmpty() && s2.isEmpty();
    }
}
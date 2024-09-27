// Time Complexity : O(n) where n is the number of integers(operations)
//  worst case is when we push elements continuously and then have to pop all of them onto the output stack.

// Space Complexity : O(n) where n is the number of integers that are being stored at any given time
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class MyQueue {
    // we keep two stacks one for input and output
    private Stack<Integer> input;
    private Stack<Integer> output;

    /** Initialize your data structure here. */
    public MyQueue() {
        input = new Stack<Integer>();
        output = new Stack<Integer>();

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        // we populate the input stack
        input.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // peek reverses the stack so as to form a queue
        peek();
        return output.pop();
    }

    /** Get the front element. */
    public int peek() {
        // here we first see if output is empty..
        if (output.empty())
            // invert the input onto the output so stack behaves like queue
            while (!input.empty()) {
                output.push(input.pop());
            }

        // if output is not empty we dont invert the input to output but just return
        // its peek

        // if output is empty we return the peek of the inverted input stack(which is
        // stored in output stack)
        return output.peek();

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        // checks if both the stacks are empty
        return input.empty() && output.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
 * obj.peek(); boolean param_4 = obj.empty();
 */
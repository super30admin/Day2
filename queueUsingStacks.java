// Time Complexity : push O(1) pop O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.Stack;

class MyQueue {
    Stack<Integer> in; // creating a stack for pushing in the elements
    Stack<Integer> out; // creating a stack for poping out the elements

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {
        in.push(x); // pushing
    }

    public int pop() {
        peek(); // call the peek function which transfers the numbers from in to out.
        return out.pop(); // pop
    }

    public int peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) { // transfering to out
                out.push(in.pop());
            }
        }

        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
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
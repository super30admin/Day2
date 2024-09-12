import java.util.*;

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack();
        out = new Stack();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        peek();
        return out.pop();
    }

    public int peek() {
        // when out stack is empty, insert values from in stack
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        // else directly peek the top element in out stack
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
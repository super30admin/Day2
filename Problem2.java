// Time Complexity : All operations will take amortized O(1) time complexity
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;

public class Problem2 {
    class MyQueue {

        // in stack will be the place where all elements will always be pushed
        // elements will be popped from out stack
        Stack<Integer> in;
        Stack<Integer> out;

        public MyQueue() {
            in = new Stack<Integer>();
            out = new Stack<Integer>();
        }

        public void push(int x) {
            in.push(x);
        }

        // if the out stack is empty then transfer all the elements from in stack to out stack and then pop from out stack
        public int pop() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.pop();
        }

        // if the out stack is empty then transfer all the elements from in stack to out stack and then peek from out stack
        public int peek() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
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
}

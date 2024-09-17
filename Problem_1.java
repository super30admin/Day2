// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

import java.util.Stack;

class MyQueue {
    private Stack<Integer> st1;
    private Stack<Integer> st2;

    public MyQueue() {
        this.st1 = new Stack<Integer>();
        this.st2 = new Stack<Integer>();
    }

    public void push(int x) {
        st1.push(x);
    }

    public int pop() {
        if (st2.isEmpty()) {
            while (!st1.isEmpty())
                st2.push(st1.pop());
        }
        return st2.pop();
    }

    public int peek() {
        if (st2.isEmpty()) {
            while (!st1.isEmpty())
                st2.push(st1.pop());
        }
        return st2.peek();
    }

    public boolean empty() {
        if (st1.isEmpty() && st2.isEmpty()) {
            return true;
        }
        return false;
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
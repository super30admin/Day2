// Time Complexity : Push - O(1), Pop - Amortized O(1), Peek - Amortized O(1), Empty - O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach: Use two stacks to simulate queue(FIFO) behavior
// Push operations are performed directly on the 'in' stack,
// Pop and peek operations transfer elements from 'in' to 'out' only when 'out' is empty

import java.util.Stack;

class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;
    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }

    public void push(int x) {
        this.in.push(x);
    }

    public int pop() {
        peek();
        return this.out.pop();
    }

    public int peek() {
        if(this.out.isEmpty()) {
            while(!this.in.isEmpty()) {
                this.out.push(this.in.pop());
            }
        }
        return this.out.peek();
    }

    public boolean empty() {
        return this.out.isEmpty() && this.in.isEmpty();
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
/***
 * TC - O(1) [insert(), remove(), peek()]
 * SC - O(n)
 */

import java.util.Stack;

class MyQueue {

    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {
        //push to the in stack
        in.push(x);
    }

    public int pop() {

        peek();

        //pop from out stack
        return out.pop();
    }

    public int peek() {
        //If out stack is empty, then move all elements from in stack to out stack
        if(!empty()) {
            if(out.isEmpty()) {
                while(!in.isEmpty()) {
                    out.push(in.pop());
                }
            }

            return out.peek();
        }

        return -1;

    }

    public boolean empty() {

        //if both stacks are empty, then return true
        if(in.isEmpty() && out.isEmpty())
            return true;

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
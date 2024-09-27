import java.util.Stack;

class MyQueue {

    // Time Complexity : For push it's 0(1), For pop it's 0(n), for peek it's 0(n), for isEmpty its 0(1).
// Space Complexity :0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

    /** Initialize your data structure here. */
    Stack<Integer> instack;
    Stack <Integer> outstack;

    public MyQueue() {
        instack = new Stack<>();
        outstack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        instack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return outstack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(instack.isEmpty() && outstack.isEmpty()){
            return -1;
        }
        if(outstack.isEmpty()){
            while(!instack.isEmpty()){

                outstack.push(instack.pop());
            }
        }
        return outstack.peek();

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return instack.isEmpty() && outstack.isEmpty();
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
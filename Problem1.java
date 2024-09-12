import java.util.Stack;

// Time Complexity : O(2n)=O(n)
// Space Complexity :O(2n)=O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//It uses 2 stacks one for push and another for pop. The functions while popping the number pop all the values from 1st stack and then remove the element. Further the elements are pushed back to the 1st stack

class MyQueue {

    Stack<Integer> st1;
    Stack<Integer> st2;

    /** Initialize your data structure here. */
    public MyQueue() {
        st1 = new Stack<Integer>();
        st2 = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {

        while (!st2.isEmpty()) {
            st1.push(st2.pop());
        }

        st1.push(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }
        return st2.pop();

    }

    /** Get the front element. */
    public int peek() {
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }
        return st2.peek();

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
 * obj.peek(); boolean param_4 = obj.empty();
 */
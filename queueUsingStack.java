/*
Given we can use 2 stacks
push --> O(1)
pop --> O(1)
peek --> O(1)
 */
import java.util.*;

class MyQueue {

    Stack<Integer> st1;
    Stack<Integer> st2;

    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();

    }

    public void queueOp() {
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }
    }

    public void revqueueOp() {
        while (!st2.isEmpty()) {
            st1.push(st2.pop());
        }
    }

    public void push(int x) {
        st1.push(x);

    }

    public int pop() {
        queueOp();
        int value = -1;
        if (!st2.isEmpty()) {
            value = st2.pop();
        }
        revqueueOp();
        return value;

    }

    public int peek() {

        queueOp();
        int value = -1;
        if (!st2.isEmpty()) {
            value = st2.peek();
        }
        revqueueOp();
        return value;

    }

    public boolean empty() {
        return st1.isEmpty();

    }
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
 * obj.peek(); boolean param_4 = obj.empty();
 */

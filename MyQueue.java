// Time Complexity : O(1) average and O(n) worst case - for push(), pop(), peek(), empty() methods.
// Space Complexity : O(n) - where n is the number of entries in the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;

public class MyQueue {
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
        System.out.println("Pushed '" + x + "' into Queue ");
    }

    public void checkAndPushToOutStack() {
        if (outStack.empty()) {
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    public int pop() {
        checkAndPushToOutStack();
        if (outStack.empty()) {
            System.out.println("Empty Queue");
            return 0;
        }
        int popItem = outStack.pop();
        System.out.println("Popped '" + popItem + "' from Queue");
        return popItem;
    }

    public int peek() {
        checkAndPushToOutStack();
        if (outStack.empty()) {
            System.out.println("Empty Queue");
            return 0;
        }
        int peekItem = outStack.peek();
        System.out.println("Peeking '" + peekItem + "' from Queue");
        return peekItem;
    }

    public boolean empty() {
        boolean isEmpty;
        if (inStack.empty()) {
            if (outStack.empty()) {
                isEmpty = true;
            } else {
                isEmpty = false;
            }
        } else {
            isEmpty = false;
        }
        System.out.println("Queue is Empty ? :" + isEmpty);
        return isEmpty;
    }

    public static void main(String[] args) {
        MyQueue mq = new MyQueue();
        mq.empty();
        mq.pop();
        mq.peek();
        mq.push(1);
        mq.push(2);
        mq.push(3);
        mq.push(4);
        mq.push(5);
        mq.push(6);
        mq.peek();
        mq.pop();
        mq.peek();
        mq.empty();
        mq.peek();
        mq.pop();
        mq.peek();
    }
}

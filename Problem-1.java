import java.util.Stack;

// Time Complexity : Push -> O(1), Pop -> O(N), Peek -> O(1)
// Space Complexity : O(N1 + N2) => O(N) [N1: space for stack1 ; N2: space for stack2]
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// We use 2 stacks based on pushing and popping action on the queue
class MyQueue {

    Stack<Integer> pusherStack; // will be used for pushing element
    Stack<Integer> popperStack; // will be used for popping element
    int front;

    /** Initialize your data structure here. */
    public MyQueue() {
        pusherStack = new Stack<>();
        popperStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (pusherStack.isEmpty()) {
            front = x;
        }
        pusherStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (popperStack.isEmpty()) {
            // Invert the pusherStack into popperStack
            // so that last element in pusherStack is at the top of popperStack
            while (!pusherStack.isEmpty()) {
                popperStack.push(pusherStack.pop());
            }
        }
        return popperStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return popperStack.isEmpty() ? front : popperStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        // If both the stacks are empty, indicates queue is empty
        return pusherStack.isEmpty() && popperStack.isEmpty();
    }
}

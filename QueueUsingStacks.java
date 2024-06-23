/*
Time Complexity:
push - O(1)
Pop - Amortized O(1)
peek - Amortized O(1)
empty - O(1)
 */
//Space Complexity - O(1)

import java.util.Stack;

class MyQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {

        stackIn.push(x);
    }

    public int pop() {
        if(stackOut.isEmpty()) {
            top();
        }
        return stackOut.pop();

    }

    private void top() {
        while(!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
    }

    public int peek() {
        if(stackOut.isEmpty()) {
            top();
        }
        return stackOut.peek();

    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();

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

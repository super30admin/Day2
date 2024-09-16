package S30_Codes.Design_2;

// Time Complexity : O(1)
// Space Complexity : O(n)
// Design - 2

import java.util.Stack;

class MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    private void transferStack(){
        while(!inStack.empty()){
            outStack.push(inStack.pop());
        }
    }

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if(outStack.empty())
            transferStack();

        return outStack.pop();
    }

    public int peek() {
        if(outStack.empty())
            transferStack();

        return outStack.peek();
    }

    public boolean empty() {
        if(inStack.empty() && outStack.empty())
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
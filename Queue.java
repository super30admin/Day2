import java.util.Stack;

class MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<Integer>();
        outStack = new Stack<Integer>();
    }

    // TC O(1) SC O(n)
    public void push(int x) {
        inStack.push(x);
    }

    // TC O(n) SC O(n)
    public int pop() {
        peek();
        return outStack.pop();
    }

    // TC O(n) SC O(n)
    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    // TC O(1) SC O(n)
    public boolean empty() {
        return (inStack.isEmpty() && outStack.isEmpty());
    }
}

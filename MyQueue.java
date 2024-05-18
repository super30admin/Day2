/**
 *
 * Time Complexity:
 * O(1) --> push(), empty()
 * Amortized O(1) -->peek(), pop()
 *
 * Space Complexity:
 * O(1) --> push(), empty(), peek(), pop()
 *
 * Algorithm:
 * - Use 2 stacks --> In Stack, out Stack
 * - while push() --> add the value to the stack
 * - while Peek() --> empty the input stack and add them into the out stack and peek the out stack
 * - While pop() --> perform all the peek then pop the value
 *
 */

import java.util.Stack;
class MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;
    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        peek();
        return outStack.pop();
    }

    public int peek() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
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
import java.util.Stack;

// Time Complexity: O(1) for push, pop (output stack is filled only when it is empty), peek and empty
// Space complexity: O(n) since using 2 stacks and total elements is n
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, initial time complexity for push was not O(1).
// Fixed by copying elements from input to output stack only when output stack is empty

class MyQueue {
    Stack<Integer> inputStack;
    Stack<Integer> outputStack;

    /**
     * Initialize stacks in constructor
     */
    public MyQueue() {
        this.inputStack = new Stack<>();
        this.outputStack = new Stack<>();
    }

    /**
     * Push item to input stack
     *
     * @param x element to enqueue
     */
    public void push(int x) {
        this.inputStack.push(x);
    }

    /**
     * Only need to look at the top of outputStack and remove it
     * And if outputStack is empty, refill it in reverse order from inputStack
     *
     * @return top element of stack
     */
    public int pop() {
        peek();
        return this.outputStack.pop();
    }

    /**
     * Only need to look at top of the outputStack
     * And if outputStack is empty, refill it in reverse order from inputStack
     *
     * @return peek into top element of stack
     */
    public int peek() {
        if (this.outputStack.isEmpty()) {
            while(!this.inputStack.isEmpty()) {
                this.outputStack.push(this.inputStack.pop());
            }
        }
        return this.outputStack.peek();
    }

    /**
     * If output stack and input stack both are empty, then the queue is empty
     *
     * @return true if empty, false otherwise
     */
    public boolean empty() {
        return this.outputStack.isEmpty() && this.inputStack.isEmpty();
    }
}
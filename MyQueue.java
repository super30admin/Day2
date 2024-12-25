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
        refillOutputStackIfEmpty();
        return this.outputStack.pop();
    }

    /**
     * Only need to look at top of the outputStack
     * And if outputStack is empty, refill it in reverse order from inputStack
     *
     * @return peek into top element of stack
     */
    public int peek() {
        refillOutputStackIfEmpty();
        return this.outputStack.peek();
    }

    /**
     * Helper method to refill outputStack using inputStack if that stack is empty
     */
    private void refillOutputStackIfEmpty() {
        if (this.outputStack.isEmpty()) {
            while(!this.inputStack.isEmpty()) {
                this.outputStack.push(this.inputStack.pop());
            }
        }
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

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
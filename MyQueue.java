import java.util.Stack;

// Time Complexity: O(n) for push, O(1) for pop, peek and empty
// Space complexity: O(n) since using 2 stacks
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, but the push operation for a queue should be O(1)

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
     * Push item to input stack and put them in reverse order in output stack
     * This is not the most optimized solution since everytime it has to go till the depth of the stack
     *
     * @param x element to enqueue
     */
    public void push(int x) {
        if (empty()) {
            this.outputStack.push(x);
            return;
        }

        while(!this.outputStack.isEmpty()) {
            this.inputStack.push(this.outputStack.pop());
        }

        this.inputStack.push(x);

        while(!this.inputStack.isEmpty()) {
            this.outputStack.push(this.inputStack.pop());
        }
    }

    /**
     * Only need to look at the top of stack and remove it
     *
     * @return top element of stack
     */
    public int pop() {
        return this.outputStack.pop();
    }

    /**
     * Only need to look at top of the stack
     *
     * @return peek into top element of stack
     */
    public int peek() {
        return this.outputStack.peek();
    }

    /**
     * If output stack is empty, then the queue is empty
     *
     * @return true if empty, false otherwise
     */
    public boolean empty() {
        return this.outputStack.isEmpty();
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
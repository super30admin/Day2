import java.util.Stack;

class MyQueue {
    private Stack<Integer> pushStack;
    private Stack<Integer> popAndTopStack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        pushStack = new Stack<>();
        popAndTopStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        pushStack.add(x);

    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (this.empty()) {
            return Integer.MAX_VALUE;
        }
        if (popAndTopStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popAndTopStack.add(pushStack.pop());
            }
        }
        return popAndTopStack.pop();

    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (this.empty()) {
            return Integer.MAX_VALUE;
        }
        if (popAndTopStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popAndTopStack.add(pushStack.pop());
            }
        }
        return popAndTopStack.peek();

    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return pushStack.isEmpty() && popAndTopStack.isEmpty();

    }

}
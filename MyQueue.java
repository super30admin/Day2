// Time Complexity : Amortized O(1)
// Space Complexity : O(n) where n is the size of the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        // Transfer all elements from inStack to outStack, reversing the order
        peek();
        return outStack.pop();
    }

    public int peek() {
        // If outStack is empty, transfer all elements from inStack to outStack
        // This ensures that the oldest element (the front of the queue) is on top of outStack
        if (outStack.isEmpty()) {
            // Transfer all elements from inStack to outStack, reversing the order
            while (!inStack.isEmpty()) {
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

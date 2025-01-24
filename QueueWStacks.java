class MyQueue {
    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        if (stackOut.isEmpty()) {
            // Transfer all elements from stackIn to stackOut
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        // Pop the front element from stackOut
        return stackOut.pop();
    }


    public int peek() {
        if (stackOut.isEmpty()) {
            // Transfer all elements from stackIn to stackOut
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        // Return the front element without removing it
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
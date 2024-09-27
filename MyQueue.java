class MyQueue {

    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> reverseStack = new Stack<Integer>();
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!reverseStack.isEmpty())
        {
            stack.push(reverseStack.pop());
        }
        stack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!stack.isEmpty())
        {
            reverseStack.push(stack.pop());
        }
        return reverseStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        while(!stack.isEmpty())
        {
            reverseStack.push(stack.pop());
        }
        return reverseStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (reverseStack.isEmpty() && stack.isEmpty());
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

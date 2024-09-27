class MyQueue {
    
    Stack<Integer> stack;
    Stack<Integer> tempStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
        tempStack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(tempStack.isEmpty()) {
            while(!stack.isEmpty()) {
                tempStack.push(stack.pop());
            }            
        }
        return tempStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(tempStack.isEmpty()) {
            while(!stack.isEmpty()) {
                tempStack.push(stack.pop());
            }            
        }
        return tempStack.peek();            
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return tempStack.isEmpty() && stack.isEmpty();
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
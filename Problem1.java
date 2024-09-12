class MyQueue {
        
        Stack<Integer> stack1;
        Stack<Integer> stack2;
        int top;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if (stack1.empty()){
            top = x;
        }
        while (!stack1.isEmpty()){
            int y = stack1.pop();
            stack2.push(y);
        }
        stack2.push(x);
        while (!stack2.isEmpty()){
            int y = stack2.pop();
            stack1.push(y);
        }
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int y = stack1.pop();
            if (!stack1.empty()){
                top = stack1.peek();
            }
        return y;
    }
    
    /** Get the front element. */
    public int peek() {
        return stack1.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
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
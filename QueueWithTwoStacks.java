class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (empty()) {
            return -1;
        }

        transfer();

        return stack2.pop();
        
    }
    
    /** Get the front element. */
    public int peek() {
        if (empty()) {
            return -1;
        }

        transfer();

        return stack2.peek();
    }

    public void transfer() {
        if (stack2.isEmpty()) {
           while (!stack1.isEmpty()) {
               stack2.push(stack1.pop()); 
           }
        
        }
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack2.isEmpty() && stack1.isEmpty();
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
class MyQueue {
    // Time Complexity : O(1) # Amortized when stack 2 is not empty
    // Time Complexity : O(2n) => O(n) when outStack is empty and we have to pop n elements from inStack and push into outStack
    // Space Complexity : O(n) # Additional memory to store the queue elements
    // Approach : using two stacks one for push and other stack for pop
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public MyQueue() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }
    
    public void push(int x) {
        inStack.push(x); // 1 2 
    }
    
    public int pop() {
        if(empty()) return -1; // invaid operation
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }
    
    public int peek() {
        if(empty()) return -1; // invaid operation
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
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
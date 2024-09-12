class MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;
    

    /** Initialize your data structure here. */
    public MyQueue() {
      
        inStack = new Stack<>();
        outStack = new Stack<>(); 
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        
        while(!inStack.isEmpty()) {
            outStack.push(inStack.pop());
            
        }
        
        inStack.push(x);
        
        while(!outStack.isEmpty()){
            inStack.push(outStack.pop());
        }
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
       return inStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
         return inStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
         return inStack.isEmpty();
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
class MyQueue {

    /** Initialize your data structure here. */
    private java.util.Stack<Integer> stack1;
    private java.util.Stack<Integer> stack2;
    public MyQueue() {
        stack1 = new java.util.Stack<>();
        stack2 = new java.util.Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        transfer();
        return stack2.pop();
        
    }
    
    /** Get the front element. */
    public int peek() {
        transfer();
        return stack2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
        
    }
    
    public void transfer(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
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
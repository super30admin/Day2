class MyQueue {
    private Stack<Integer> stck1;
    private Stack<Integer> stck2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stck1 = new Stack<>();
        stck2 = new Stack<>();
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stck1.push(x);
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return stck2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(stck2.isEmpty()){
            while(!stck1.isEmpty()){
                stck2.push(stck1.pop());
            }
      }
        return stck2.peek();
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stck1.isEmpty() && stck2.isEmpty();
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

class MyQueue {
    Stack<Integer> s1; 
    //any push operations will be done on s1

    // to pop we will empty s1 into S2 so we get the FIFO order and pop
    // same for the peek
    
    Stack<Integer> s2;
    /** Initialize your data structure here. */
    public MyQueue() {
        
        // will use for push operations
        s1 = new Stack<Integer>();
        
        s2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                
                s2.push(s1.peek());
                s1.pop();
            }
        }
        int ans = s2.peek();
        s2.pop();
        return ans; 
     
    }
    
    /** Get the front element. */
    public int peek() {
        
        if(s2.isEmpty())
        {
            while(!s1.isEmpty()){
                s2.push(s1.peek());
                s1.pop();
            }        
        }
        return s2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (s1.isEmpty() && s2.isEmpty());
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

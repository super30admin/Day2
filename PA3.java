class MyQueue {

    /** Initialize your data structure here. */
    Stack stin;
    Stack stout;
    
    public MyQueue() {
        stin = new Stack<Integer>(); 
        stout= new Stack<Integer>();
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stin.push(x);
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stout.isEmpty()){
            while(!stin.isEmpty()){
                stout.push(stin.pop());
            }
        }
        
            return (int) stout.pop();

        
    }
    
    /** Get the front element. */
    public int peek() {
        if(stout.isEmpty()){
            while(!stin.isEmpty()){
                stout.push(stin.pop());
            }
        }
        
            return (int)stout.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stin.isEmpty() && stout.isEmpty();
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
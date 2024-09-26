class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> lifo;
    Stack<Integer> fifo;
    public MyQueue() {
        lifo = new Stack<Integer>();
         fifo = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        
        lifo.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(fifo.isEmpty())
        {
           while(!lifo.isEmpty())
        {
            fifo.push(lifo.pop());
        }   
        }
      
        
        return fifo.pop();
    }
    
    /** Get the front element. */
    public int peek() {
         if(fifo.isEmpty())
        {
           while(!lifo.isEmpty())
        {
            fifo.push(lifo.pop());
        }   
        }
        
        
             return fifo.peek();
        
    
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(fifo.isEmpty() && lifo.isEmpty())return true;
        return false;
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
class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> stack1 ;
    Stack<Integer> stack2;
    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
       if(!stack2.isEmpty())
           return stack2.pop();
        
        else
        {
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
        
          
    }
    
    /** Get the front element. */
    public int peek() {
         if(!stack2.isEmpty())
           return stack2.peek();
        
        else
        {
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stack1.isEmpty() && stack2.isEmpty())
            return true;
        else
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


   
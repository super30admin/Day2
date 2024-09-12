class MyQueue {
    private Stack<Integer> stk1;
    private Stack<Integer> stk2;
    /** Initialize your data structure here. */
    public MyQueue() {
        stk1 = new Stack<>(); // intermed stack
        stk2 = new Stack<>(); // queue
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stk1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!stk2.isEmpty()){
        return stk2.pop();
      }
      else if(!stk1.isEmpty()){
        while(!stk1.isEmpty()){
          stk2.push(stk1.pop());
        }
        return stk2.pop();
      }
      else{
        System.out.println("Queue is empty!");
        return -1;
      }
    }
    
    /** Get the front element. */
    public int peek() {
      if(!stk2.isEmpty()){
        return stk2.peek();
      }
      else if(!stk1.isEmpty()){
        while(!stk1.isEmpty()){
          stk2.push(stk1.pop());
        }
        return stk2.peek();
      }
      return -1;
      
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
      return stk2.isEmpty() && stk1.isEmpty();
        
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

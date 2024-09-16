class MyQueue {
	Stack stack2=new Stack();
	Stack stack=new Stack();
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!stack.isEmpty())
        {
        	stack2.push(stack.pop());
        	
        }
        return stack2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
       if(stack2.isEmpty()) {
    	   while(!stack.isEmpty())
            {
           	stack2.push(stack.pop());
           	}
       }
       return stack2.peek();
    	   
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stack.isEmpty() && stack2.isEmpty())
        	return true;
        else
        	return false;
    }
    
    public static void main(String args[])
    {
    	MyQueue myQueue = new MyQueue();
    	myQueue.push(1); // queue is: [1]
    	myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
    	myQueue.peek(); // return 1
    	myQueue.pop(); // return 1, queue is [2]
    	System.out.print("print"+myQueue.empty()); // return false
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
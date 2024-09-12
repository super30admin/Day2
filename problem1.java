class MyQueue {

    Stack<Integer> st = new Stack<Integer>();
    Stack<Integer> st1 = new Stack<Integer>();

    /** Initialize your data structure here. */
    public MyQueue() {
        
        
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        
        st.push(x);
        
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
	        
	        
	        while(!st.empty())
	        {
	            int temp=st.pop();
	            st1.push(temp);
	            
	            
	        }
	        int result= st1.pop();
	        while(!st1.empty())
	        {
	            int temp=st1.pop();
	            st.push(temp);
	            
	        }
	        return result;
	    }
	    
	    /** Get the front element. */
	    public int peek() {
	        
	    	while(!st.empty())
	        {
	            int temp=st.pop();
	            st1.push(temp);
	            
	        }
	        int result= st1.peek();
	        
	        while(!st1.empty())
	        {
	            int temp=st1.pop();
	            st.push(temp);
	            
	        }
	        return result;
	        
	    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        
        return st.empty();
        
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

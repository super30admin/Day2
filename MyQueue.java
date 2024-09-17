// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Used 2 stacks, one for popping and another for pushing. will reverse the stack for eachb operation

class MyQueue {

    /** Initialize your data structure here. */
	Stack<Integer> stack1;
	Stack<Integer> stack2;
	
	
    public MyQueue() {
       stack1= new Stack();
       stack2= new Stack();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    	
    	while(!(stack1.isEmpty())){
   		 int s=stack1.pop();
   		 stack2.push(s);
   	 }
    	
         while(!(stack2.isEmpty())){
        	 int y=stack2.pop();
        	 stack1.push(y);
        	 
         }
         stack1.push(x);
         
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	
    	while(!(stack2.isEmpty())){
       	 int y=stack2.pop();
       	 stack1.push(y);
       	 
        }
    	
    	 while(!(stack1.isEmpty())){
    		 int x=stack1.pop();
    		 stack2.push(x);
    	 }
    	 return stack2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
    	if(stack2.isEmpty()) {
    		 while(!(stack1.isEmpty())){
        		 int x=stack1.pop();
        		 stack2.push(x);
        	 }
    	}
        return stack2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (stack1.isEmpty() || stack2.isEmpty());
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
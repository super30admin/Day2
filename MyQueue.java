// Time Complexity : O(1)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//Implemented using two stacks st1 and st2 st1 is used to push new elements and st2 is used to pop the elements in between elements are swapped between them to enqueue and dequeue

class MyQueue {
	
	Stack st1=new Stack();
	Stack st2=new Stack();

    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    public void swapStack(Stack from , Stack to)
    {
    	while(!from.isEmpty())
    	{
    		to.push(from.pop());
    	}
    	
    }
    
    /** Push element x to the back of queue. */
	// 
    public void push(int x) {
    	if(st1.isEmpty())
    	{
    		if(st2.isEmpty())
    		{
    			st1.push(x);
    		}
    		if(!st2.isEmpty())
    		{
    			swapStack(st2,st1);
    			st1.push(x);
    		}
    	}
    	else {st1.push(x);}       
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	
    	if(st1.isEmpty())
    	{
    		if(st2.isEmpty())
    		{
    			return -1;
    		}
    		else {return (int)st2.pop();}
    	}
    	else
    	{
    		swapStack(st1,st2);
    		return (int)st2.pop();
    	}
        
    }
    
    /** Get the front element. */
    public int peek() {
    	
    	if(st1.isEmpty())
    	{
    		if(st2.isEmpty())
    		{
    			return -1;
    		}
    		else {return (int)st2.peek();}
    	}
    	else
    	{
    		swapStack(st1,st2);
    		return (int)st2.peek();
    	}
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
    	if(st1.isEmpty()&&st2.isEmpty())
    	{
    		return true;
    	}
    	else {return false;}
        
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
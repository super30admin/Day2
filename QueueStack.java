// Time Complexity : O(1) 
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Used two stacks here where in the 'in' stack we maintain all the elemets when we have pushed into the queue.
//As stack is first in last out , whenever we want to perform peek or pop in the queue which is first in first out, we have to pop every element to the 
//'out' stack so that the element at the bottom of the in stack comes to the top of the 'out' stack.
//Basically the in stack is used only for push operations , but for pop and peek we always have to move elements to the 'out' stack to maintain the FIFO behavior of queue

class MyQueue {
    
    Stack<Integer> in;
    Stack<Integer> out;

    /** Initialize your data structure here. */
    public MyQueue() {
        //initialise two stacks in and out.
        in = new Stack<>();
        out = new Stack<>();
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        //push element into to 'in' stack
        in.push(x);
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	//push all elements to the 'out' stack
        peek();
        
        //top of the stack is first element of the queue
        return out.pop();
        
    }
    
    /** Get the front element. */
    public int peek() {
        if(out.isEmpty())
        {
            while(!in.isEmpty())
            {
                out.push(in.pop());
            }
        }
        return out.peek();
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
    	//only if both are empty return true
        if(in.isEmpty() && out.isEmpty())
        {
            return true;
        }
        
        else
        {
            return false;
        }
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
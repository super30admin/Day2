// Problem : Implement Queue using Stacks
// Time Complexity :O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 


// Your code here along with comments explaining your approach
class MyQueue {
    private Stack in;
    private Stack out;
    /** Initialize your data structure here. */
    public MyQueue() {
        in = new Stack<Integer>();  // Used for pushing data into the queue
        out = new Stack<Integer>(); // used for peek and pop operations on queue
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);             // push data only in queue     
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
       if(out.isEmpty())    // if pop comes for the first time or the out stack is empty after a series of pop check whether out stack is empty 
       {
           while(!in.isEmpty())   // push data from in to out this will reverse the arrangement of data in the in stack 
           {
               out.push(in.pop());  
           }
       }
        
        return (int)out.pop();  // pop the data from the out data as it is in FIFO order
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
        
        return (int)out.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        
        if(out.isEmpty() && in.isEmpty())
            return true;
        
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
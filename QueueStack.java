// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



// Your code here along with comments explaining your approach

My approach is using two stacks input and output respectively.

We will push the values to input stack. But when we pop the the values we will check if the input stack is empty or not.

If it's not empty we will pop the input stack values and push them in output stack. and when someone asks to pop the value fro queue we 

will return the top value of output stack. Hence, meeting the requirement of FIFO in Queue.  


class MyQueue {
    
    Stack <Integer> input;
    Stack <Integer> output;


    /** Initialize your data structure here. */
    public MyQueue() {
        
        input = new Stack<>();
        output= new Stack<>();
 
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!input.isEmpty())
        {
            output.push(input.pop());
        }
        int top = output.pop(); 
        while (!output.isEmpty())
        {
            input.push(output.pop());
        }
        return top;
    }
    
    /** Get the front element. */
    public int peek() {
        
         while(!input.isEmpty())
        {
            output.push(input.pop());
        }
        int top = output.peek(); 
        while (!output.isEmpty())
        {
            input.push(output.pop());
        }
        return top;
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
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
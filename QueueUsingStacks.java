// Time Complexity :o(1)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyQueue {
    Stack<Integer>pushstack;
    Stack<Integer>popandpeekstack;

    /** Initialize your data structure here. */
    public MyQueue() {
        pushstack=new Stack();
        popandpeekstack=new Stack();
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        pushstack.push(x);
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(popandpeekstack.isEmpty()){
            while(!pushstack.isEmpty())
                popandpeekstack.push(pushstack.pop());
        } 
       return popandpeekstack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(popandpeekstack.isEmpty()){
            while(!pushstack.isEmpty())
                popandpeekstack.push(pushstack.pop());
        } 
        return popandpeekstack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        
        return popandpeekstack.isEmpty() && pushstack.isEmpty();
    }
}
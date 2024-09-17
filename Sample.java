// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

import java.util.Stack;

class MyQueue {
       
    Stack<Integer> s1 = new Stack<>(); // stacks for implementing queue
    Stack<Integer> s2 = new Stack<>();
    int first =-1; // initializing first

    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {   // we just push the value to the stack after checking if its empty or not
        if(s1.empty())
            first = x;
        s1.push(x);         
    }
    
    /** Removes the element from in front of queue and returns that element. */
    // while popping to make sure we pop the first element thats in -> we pop all elements from s1 and push to s2.
    // Now we have s2 which follows the order of insertion required to get fifo by popping. Just popping first element will get the result.
    public int pop() {       
        if(s2.isEmpty()){
            while(!s1.isEmpty())
                s2.push(s1.pop());
        } 
        return s2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(!s2.isEmpty())
            return s2.peek();
        return first;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
       return s1.isEmpty() && s2.isEmpty();
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
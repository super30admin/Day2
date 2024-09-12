// Time Complexity : Push - O(1), pop - O(n) worst case , Empty & peek : O(1) [n=size of queue]
// Space Complexity : Push- O(n), pop: O(1), Empty & peek : O(1) [n=size of queue]
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.Stack;
class MyQueue {
    private Stack<Integer> s1=new Stack<>();
    private Stack<Integer> s2=new Stack<>();
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        /* Check for stack2 being empty, and if it's empty then pop all the elements
         from s1 and push them into s2.
        Otherwise, just pop the element from s2
        */
        if(s2.isEmpty()){
            while(!s1.isEmpty())
                s2.push(s1.pop());
        }
        return s2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        /* If stack2 isnt empty then just return the top element of s2.
           Else,  pop all the elements from stack1 and push them into stack2, 
           return the top element in s2
        */
        if(!s2.isEmpty()){
            return s2.peek();
        } else {
            while(!s1.isEmpty()) 
                s2.push(s1.pop());
        }
        return s2.peek();
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
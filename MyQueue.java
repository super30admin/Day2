import java.util.Stack;

// Time Complexity : push - O(1) , pop - O(1) , peek() = O(1), empty-O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class MyQueue {
  Stack<Integer> s;
  Stack<Integer> temp;  
    /** Initialize your data structure here. */
    public MyQueue() {
        s = new Stack<Integer>();
        temp = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        s.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        
        if(!temp.isEmpty())
           return temp.pop();
        
        while(!s.isEmpty())
        {
            temp.push(s.pop());
        }
        return temp.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        
        if(!temp.isEmpty())
           return temp.peek();
        
         while(!s.isEmpty())
        {
            temp.push(s.pop());
        }
        return temp.peek();
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s.isEmpty() && temp.isEmpty();
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
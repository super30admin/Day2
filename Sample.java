// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class MyQueue {
   Stack st1;
    Stack st2;
    /** Initialize your data structure here. */
    public MyQueue() {
        st1 = new Stack<Integer>();
        st2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        st1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int result ;
        while(!st1.isEmpty())
        {
            st2.push(st1.pop());
        }
        result = (int)st2.pop();
         while(!st2.isEmpty())
        {
            st1.push(st2.pop());
        }
        return result;
    }
    
    /** Get the front element. */
    public int peek() {
        int result ;
        while(!st1.isEmpty())
        {
            st2.push(st1.pop());
        }
        result = (int)st2.peek();
         while(!st2.isEmpty())
        {
            st1.push(st2.pop());
        }
        return result;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st1.isEmpty();
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
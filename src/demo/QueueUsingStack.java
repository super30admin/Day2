package demo;

import java.util.Stack;

//Time complexity : pop = O(n)
//Space Complexity: O(n)
//LeetCode : yes


class MyQueue {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> st2 = new Stack<>();
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        st.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(st2.isEmpty()){
        		while(!st.isEmpty()) {
            int popped = st.pop();
            st2.push(popped);
        		}
        }
        return st2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
         if(st2.isEmpty())
       {
           while(!st.isEmpty()){
                int peeked = st.pop();
               st2.push(peeked);
           }

       }
       return st2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(st.isEmpty() && st2.isEmpty()){
            return true;
        }
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

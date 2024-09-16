// Time Complexity : O(1), O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class MyQueue {
    Stack<Integer> st1 = new Stack<Integer>();
    Stack<Integer> st2 = new Stack<Integer>();
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        st1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(st1.empty() == false){
            st2.push(st1.pop());
        }
        int x = st2.peek();
        st2.pop();
        while(st2.empty() == false){
            st1.push(st2.pop());
        }
        return x;
    }
    
    /** Get the front element. */
    public int peek() {
        while(st1.empty() == false){
            st2.push(st1.pop());
        }
        int x = st2.peek();
        while(st2.empty() == false){
            st1.push(st2.pop());
        }
            
        return x;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st1.isEmpty();
    }
}


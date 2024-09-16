// Time Complexity : O(N)- pop,peek and O(1) - push,Empty()
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.Stack;

class MyQueue {

    Stack<Integer> st1;
    Stack<Integer> st2;
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
        while(st1.size()>1){
            st2.push(st1.pop());
        }
        int elem = st1.pop();
        while(st2.size()>0){
            st1.push(st2.pop());
        }
        return elem;
    }
    
    /** Get the front element. */
    public int peek() {
        while(st1.size()>0){
            st2.push(st1.pop());
        }
        int elem = st2.peek();
        while(st2.size()>0){
            st1.push(st2.pop());
        }
        
        return elem;

    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st1.isEmpty();
    }
}


// Time Complexity : O(1) for push,pop,peek and empty operations.
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// First create two stacks called in and out stacks. For push operation use in stack to push the element. For 
// pop operation see if elements are present in the out stack, if present element can be popped from out stack,
// otherwise use in stack elements to fill the outstack and then pop the element from out stack. Same goes with 
// the peek operation. For empty operation make sure that both the stacks are empty.

import java.util.Stack;

class MyQueue {
    
    Stack<Integer> s1;
    Stack<Integer> s2; 

    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if(s2.size()>0){
            return s2.pop();
        }
        else{
            while(s1.size()>0){
                s2.push(s1.pop());
            }
            return s2.pop();
        }
    }
    
    public int peek() {
        if(s2.size()>0){
            return s2.peek();
        }
        else{
            while(s1.size()>0){
                s2.push(s1.pop());
            }
            return s2.peek();
        }
    }
    
    public boolean empty() {
        if(s1.size()+s2.size()>0){
            return false;
        }
        else{
            return true;
        }
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

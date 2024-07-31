//Implement Queue using stacks
// Time Complexity : Push Operation - O(1), Pop Operation - Amortized O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this: No
// Approach: I am pushing an element to stack 1 and whenever I do a pop, I remove all elements from stack 1 to stack 2, then pop from stack 2

import java.util.Stack;
class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    public MyQueue() {
        this.s1 = new Stack();
        this.s2 = new Stack();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if(s2.empty()) {
                while(!s1.empty()) {
                s2.push(s1.pop());
            }
            return s2.pop();
        } else{
            return s2.pop();
        }
    }
    
    public int peek() {
        if(s2.empty()) {
            while(!s1.empty()) {
                s2.push(s1.pop());
            }
            return s2.peek();
        } else{
            return s2.peek();
        }
    }
    
    public boolean empty() {
        return s1.empty() && s2.empty();
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
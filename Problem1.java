//Problem 1: Implement Queue using Stacks
//Time Complexity :  O(1)
//space complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        this.s1= new Stack<>();
        this.s2= new Stack<>();
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        this.s1.push(x);

    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(this.s2.isEmpty()){
            while(!this.s1.isEmpty()){
                this.s2.push(this.s1.pop());
            }
        }
        return this.s2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(this.s2.isEmpty()){
            while(!this.s1.isEmpty()){
                this.s2.push(this.s1.pop());
            }
        }
        return this.s2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.s1.isEmpty() && this.s2.isEmpty();
    }
}
// Time Complexity : Amortized O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// S30 ID: Sawan Chakraborty_RN69DEC2024

import java.util.Stack;

class MyQueue {
    Stack<Integer> in;// input stack
    Stack<Integer> out;// output stack acting as queue
    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }
    
    public void push(int x) {
        this.in.push(x);
    }
    
    public int pop() {
        peek(); // calling peek to move elements to out stack
        return this.out.pop();
    }
    
    public int peek() {
        if(this.out.isEmpty()){
            while(!this.in.isEmpty()){
                this.out.push(this.in.pop()); // pushing elements to out stack
            }
        }
        return this.out.peek();
    }
    
    public boolean empty() {
        return this.in.isEmpty() && this.out.isEmpty(); // checking empty condition
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
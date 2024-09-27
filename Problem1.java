// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;
    /** Initialize your data structure here. */
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        //push only in stack "in"
        in.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //peek will ensure that the "out" stack is not empty
        peek();
        //pop only from "out" stack
        return out.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        //if "out" stack is empty, push all the elements from "in" stack to "out" stack
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        //peek only from "out" stack
        return out.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        //return if "in" and "out" both the stacks are empty
        return in.isEmpty() && out.isEmpty();
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
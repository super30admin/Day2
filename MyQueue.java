import java.util.Stack;

// Time Complexity : Push Operation O(1) and Pop operation O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class MyQueue {
    //Initializing two stacks
    Stack<Integer> in = new Stack<>(); 
    Stack<Integer> out = new Stack<>();
    /** Initialize your data structure here. */
    public MyQueue() {
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        //Push the incoming element in the stack 1 i.e in
        in.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //if out stack is empty pop all the elements from the in stack to the out stack till the in stack is empty
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        // if the out stack is not empty pop the first element from the out stack 
        return out.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        //if out stack is empty pop all the elements from the in stack to the out stack till the in stack is empty
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
     }
}

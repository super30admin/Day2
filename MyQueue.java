import java.util.Stack;

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyQueue {
    
    //We will be using two stacks, the in for pushing and out for popping
    Stack<Integer> in, out;

    /** Initialize your data structure here. */
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }
    
    //transfer while popping so that the order switches
    private void transfer(Stack<Integer> in, Stack<Integer> out){
        while(!in.isEmpty()){
            out.push(in.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //call peek so the if statement transfers the elements
        peek();
        return out.pop();
        
    }
    
    /** Get the front element. */
    public int peek() {
        //transfer to switch the order of the elements
        if(out.isEmpty()){
            transfer(in, out);
        }
        return out.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        //have to check both stacks in order to declare the queue to be empty
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
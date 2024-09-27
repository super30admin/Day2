// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.Stack;
class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> stack1, stack2;
    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int x=0;
        if(!stack2.empty()){
            x = stack2.pop();
        }else if(!stack1.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
            x = stack2.pop();
        }
        return x;
    }
    
    /** Get the front element. */
    public int peek() {
        int x=0;
        if(!stack2.empty()){
            x = stack2.peek();
        }else if(!stack1.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
            x = stack2.peek();
        }
        return x;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stack1.empty() && stack2.empty())
            return true;
        else
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

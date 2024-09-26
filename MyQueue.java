// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

import java.util.Stack;

class MyQueue {
    Stack<Integer> stack, stack2;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
        stack2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack2.isEmpty())
        {
            while(!stack.isEmpty())
            {
                stack2.push(stack.pop());
            }
        }
       return stack2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(stack2.isEmpty())
        {
            while(!stack.isEmpty())
            {
                stack2.push(stack.pop());
            }
        }
       return stack2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if( stack.isEmpty() && stack2.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }





public static void main(String[] args) {
  MyQueue obj = new MyQueue();
  obj.push(1);
  obj.push(2);
  int param_3 = obj.peek();
  int param_2 = obj.pop();
  
  boolean param_4 = obj.empty();
    
  System.out.println(param_2 + " " +param_3 + " " + param_4);
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
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
import java.util.Stack;

class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(stack1.isEmpty() && stack2.isEmpty()){          
                stack1.push(x);      
        }
        else if(!stack1.isEmpty() && stack2.isEmpty()){
                stack1.push(x);
        }
        else {
                while(!stack2.isEmpty()){
                
                stack1.push(stack2.pop());
                }
            stack1.push(x);
        }  
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack2.isEmpty()){
            if(stack1.isEmpty()){
                return -1;
            }
            while(!stack1.isEmpty()){
            
            stack2.push(stack1.pop());
        }
            return (int)stack2.pop();
        }
        else{
            return (int)stack2.pop();
        }    
    }
    
    /** Get the front element. */
    public int peek() {
        if(stack2.isEmpty()){
            if(stack1.isEmpty()){
                return -1;
            }
           while(!stack1.isEmpty()){
            
            stack2.push(stack1.pop());
        }
            return (int)stack2.peek();
        }
        else{
            return (int)stack2.peek();
        }
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stack1.isEmpty() && stack2.isEmpty()){
            return true;
        }
        return false;
    }
}
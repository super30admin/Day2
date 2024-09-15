import java.util.Stack;

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : Took Hint to figure out the logic part


// Your code here along with comments explaining your approach

class MyQueue {

    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    Stack<Integer> stk1 = new Stack<>();
    Stack<Integer> stk2 = new Stack<>();
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(stk1.empty()){
            stk1.push(x);
        }else{
            while(!stk1.empty()){
                stk2.push(stk1.pop());
            }
            
            stk1.push(x);
            
            while(!stk2.empty()){
                stk1.push(stk2.pop());
            }
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // if(!stk1.empty()){
            return stk1.pop();
        // }

    }
    
    /** Get the front element. */
    public int peek() {

            return stk1.peek();

    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stk1.size()==0){
            return true;
        }
        
        return false;
    }
}
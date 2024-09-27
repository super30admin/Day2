// Time Complexity : Push -O(1), pop- avgO(1) , peek- avg O(1), worst O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : index out of bound
//using 2 stacks to get FIFO of queue 


import java.util.Stack;

class MyQueue {
Stack<Integer> s1; 

Stack <Integer> s2;
    //initializing 2 stacks for in and out
    public MyQueue() {
        this.s1 = new Stack<>();
        this.s2 =  new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
    	//if stack 2 is empty then transfer items from stack 1 to 2 
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
             
        }
        return s2.pop();
    }
    
    public int peek() {
      
         if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }  
        }
        
        return s2.peek();
    }
    
    
    public boolean empty() {
        if(s1.isEmpty() && s2.isEmpty()){
            return true;
        }
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


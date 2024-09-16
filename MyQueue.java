// Time Complexity : O(1) --> push O(n) --> pop 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Since I am using 2 stack method my one of operation is going in 
// O(n) for example: here push is O(1) but pop is O(n) if I try 
// pop in O(1), push is going in O(n)

// not sure if all operation cab be done in O(1)


import java.util.Stack;

class MyQueue {

    /** Initialize your data structure here. */
    private Stack<Integer> first_stack;
    private Stack<Integer> second_stack;
    public MyQueue() {
        first_stack =new Stack<Integer>();
        second_stack =new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        first_stack.push(x);
        System.out.println(" Element is added "+x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(second_stack.isEmpty()){
            while(!first_stack.isEmpty()){
                second_stack.push(first_stack.pop());
            }           
        }
        int popped=second_stack.pop();
        System.out.println(" element is popped "+popped);
        return popped;
        
    }
    
    /** Get the front element. */
    public int peek() {
        if(second_stack.isEmpty()){
            while(!first_stack.isEmpty()){
                second_stack.push(first_stack.pop());
            }           
        }    
        System.out.println(" element is popped "+second_stack.peek());
        return second_stack.peek();
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(second_stack.isEmpty() && first_stack.isEmpty()){
            System.out.println(" Queues is empty");
            return true;
        }
            
        else{
           System.out.println(" Queue is not empty");
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

public static void main(String args[]) 
{ 
    MyQueue obj = new MyQueue();
    obj.push(10);
    obj.push(7);
    obj.push(15);
    obj.push(20);
    int param_2 = obj.pop();
    int param_3 = obj.peek();
    boolean param_4 = obj.empty();
}
}
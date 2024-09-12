import java.util.Stack;
//Time Complexity : 
//Push O(1)
//Pop O(n)
//Peek O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


//Your code here along with comments explaining your approach

public class MyQueue {
    
    private Stack<Integer> stackA;
    private Stack<Integer> stackB;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        stackA = new Stack<Integer>();
        stackB = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stackA.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stackB.isEmpty()){
            while(!stackA.isEmpty()){
                stackB.push(stackA.pop());
            }
        }
        return stackB.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(!stackB.isEmpty()){
            return stackB.peek();
        }else {
            while(!stackA.isEmpty()){
            stackB.push(stackA.pop());   
            }            
        }return stackB.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackA.isEmpty() && stackB.isEmpty();
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
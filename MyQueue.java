//Problem1 : implement queue using stacks
import java.util.*;
class MyQueue {
    Stack<Integer> pushStack = new Stack<>();
    Stack<Integer> popStack = new Stack<>();
    int front;
    /** Initialize your data structure here. */
     public MyQueue() {
         
     }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(pushStack.empty())
            front = x;
        pushStack.push(x);
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(empty())
            throw new EmptyStackException();
        if(popStack.empty()){
            while(!pushStack.empty()){
                popStack.push(pushStack.pop());
            }
        }
       return popStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(popStack.isEmpty())
            return front;
            return popStack.peek();            
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return pushStack.empty() && popStack.empty();
       
    }
}

/* 
 Time Complexity : 
 For the push operation, the complexity is O(1).
 For the pop operation, the complexity is O(1) in the best/avg case and O(n) in the 
 worst case as when the pop stack is empty, we need to iterate through the push stack 
 and load the pop stack with values

 Space Complexity : O(n) as at any point of time, there are n elements stored in
 both the push and pop stack taking additional space. 

 Did this code successfully run on Leetcode :Yes

 Any problem you faced while coding this :No 

Your code here along with comments explaining your approach

- Push operation = Push the elements into the push stack. Maintain the value of the first
element on stack so that it can be returned as peek element when the pop stack is empty

- Pop operation = If the pop stack is empty, get elements from push stack into pop stack
and then pop it out of the pop stack.

-Peek operation = Return the top element of the pop stack. If pop stack is empty, return the
element front maintained while filling the push stack.

- empty = check both the push and pop stacks are empty.
*/
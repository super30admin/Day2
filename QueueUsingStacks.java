//Exercise_1 : Implement Queue using Stacks
// Time Complexity : Push -> O(1), Pop and Peek -> average(amortized) - O(1) and worst -O(n), Empty -> O(1) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No


// Your code here along with comments explaining your approach

//Note: I used two stacks called push and pop stack. I'm inserting new elements in the push stack. Whenever pop or peek operations are called I'm checking whether pop stack is empty or not. If pop stack is empty I'm transfering all elements from push stack to the pop stack and then performing the desired action which is pop or peek accordingly. If pop stack is not empty then I'm just performing the desired operation. 

/**** Steps ****/
/*
  1) Declare two stack one is push and other one is pop as global variables.
  2) Push -> For the push operation insert in the push stack. TC -> O(1)
  3) Pop  -> Check whether pop stack is empty or not, if it is empty transfer all the push stack elements to the pop stack elements and then perform the pop operation on the pop stack. If pop stack is not empty, then just perform the pop opeartion on the pop stack. TC -> Average -O(1), worst - O(n).
  4) Peek  -> Check whether pop stack is empty or not, if it is empty transfer all the push stack elements to the pop stack elements and then perform the peek operation on the pop stack. If pop stack is not empty, then just perform the peek opeartion on the pop stack. TC -> Average -O(1), worst - O(n).
  5) Empty -> if both stack is empty return true otherwise return false; TC -> O(1)

*/

import java.util.*

;class MyQueue {

    Stack<Integer> pushStack;
    Stack<Integer> popStack;    
    /** Initialize your data structure here. */
    public MyQueue() {
        pushStack = new Stack<>();
        popStack  = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        pushStack.add(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        
        transferPushStackElem();
        return popStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        
         transferPushStackElem();
             
          return popStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        
        if(!pushStack.isEmpty() || !popStack.isEmpty()){
            return false;
        }
        
        return true;
    }
    
    public void transferPushStackElem(){
        
        if(popStack.isEmpty()){
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
        
        
    }
    
}
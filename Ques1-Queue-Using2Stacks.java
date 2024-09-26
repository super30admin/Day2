//Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)

// Time Complexity : Push is always O(1). Pop is O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// I have used 2 stacks. PushStk and PopStk.
// PushStk is where I push the new incoming elements.
// PopStk is the stack from which I pop/peek the elements.
// If the PopStk is empty for the pop/peek operation, I push all the elements from the PushStk into the PopStk.
class MyQueue {
    Stack<Integer> pushStk;
    Stack<Integer> popStk; 

    /** Initialize your data structure here. */
    public MyQueue() {
         pushStk = new Stack<Integer>();
         popStk = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        pushStk.push(x);
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(popStk.isEmpty()){
            while(!pushStk.isEmpty()){
                popStk.push(pushStk.pop());
            }
            return popStk.pop();
        }
        return popStk.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(popStk.isEmpty()){
            while(!pushStk.isEmpty()){
                popStk.push(pushStk.pop());
            }
            return popStk.peek();
        }
        return popStk.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(pushStk.isEmpty() && popStk.isEmpty()){
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
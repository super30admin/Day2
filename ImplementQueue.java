// Time Complexity : push is O(n), pop and peek would be O(1)
// Space Complexity : O(n) depending on the elements in the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Used the front and rear concepts of the queue but then relaized I didn't need them


// Your code here along with comments explaining your approach

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
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!stack1.isEmpty()){
            return stack1.pop();
        }
        else{
            return -1;
        }
    }
    
    /** Get the front element. */
    public int peek() {
        if(!stack1.isEmpty()){
            return stack1.peek();
        }
        else{
            return -1;
        }
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stack1.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}
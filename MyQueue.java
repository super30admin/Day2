/*
 *  Time Complexity: O(1) for push and O(N) for pop and peek operation since we have to move all the elements from in stack to out stack.
 *  Space Complexity: O(N) to store all the element in the stack.
 * 
 *  Did this code successfully run on Leetcode : Yes
 *  Any problem you faced while coding this : None
 * 
 *  Push all the elements in an in stack always. If there is a pop or peek operation we move all the elements in in stack to out stack and pop or peek the top elements. We then carry out all the pop operation in the out stacks untill we run out of elements, if we run out of elements we then push all the elements from in to out stack and continue.
 */

class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> inStack;
    Stack<Integer> outStack;
    public MyQueue() {
        inStack = new Stack();
        outStack = new Stack();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(this.empty()) return -1;
        peek();
        return outStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(this.empty()) return -1;
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }    
        }
        return outStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
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

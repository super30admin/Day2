// Time Complexity : 0(n)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class MyQueue {
    

    Stack<Integer> stack1;
    Stack<Integer> stack2;
    
    int front;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    // only if stack1 is empty, update variable front
    public void push(int x) {
        if(stack1.isEmpty()){
            front = x;
        }
        // always push in stack1
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    // if stack2 is not empty, pop form it, else, refill stack2 from stack1 and pop frm stack2. 
    // Always pops element form stack2
    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    
    // if stack2 is not empty, peek the top element, else return front
    /** Get the front element. */
    public int peek() {
        if(!stack2.isEmpty()){
            front = stack2.peek();
        }
        return front;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stack1.isEmpty() && stack2.isEmpty()){
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
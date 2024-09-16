// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyQueue {

    Stack<Integer> enqueueStack;
    Stack<Integer> dequeueStack;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        enqueueStack = new Stack<>();
        dequeueStack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        enqueueStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!dequeueStack.isEmpty())
            return dequeueStack.pop();
        else
        {
            while(!enqueueStack.isEmpty())
                dequeueStack.push(enqueueStack.pop());
            return dequeueStack.pop();
        }
        
            
    }
    
    /** Get the front element. */
    public int peek() {
        if(!dequeueStack.isEmpty())
            return dequeueStack.peek();
        else
        {
            while(!enqueueStack.isEmpty())
                dequeueStack.push(enqueueStack.pop());
            return dequeueStack.peek();
        }
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (dequeueStack.size()+enqueueStack.size() == 0);
    }
    
    public int size()
    {
        return dequeueStack.size()+enqueueStack.size();
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
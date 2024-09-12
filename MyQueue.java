import java.util.Stack;

// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyQueue {
    private Stack<Integer> queue;
    private Stack<Integer> stack;
    /** Initialize your data structure here. */
    public MyQueue() {
        queue = new Stack<>();
        stack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        queue.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(queue.size() != 1){
            stack.push(queue.pop());
        }
        int retVal = queue.pop();
        while(!stack.isEmpty()){
            queue.push(stack.pop());
        }
        return retVal;
    }
    
    /** Get the front element. */
    public int peek() {
        while(queue.size() != 1){
            stack.push(queue.pop());
        }
        int retVal = queue.peek();
        while(!stack.isEmpty()){
            queue.push(stack.pop());
        }
        return retVal;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue.isEmpty();
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
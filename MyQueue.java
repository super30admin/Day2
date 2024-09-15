/**
Time Complexity :
 - push(): O(1)
 - pop(): O(n)
 - peek(): O(n) 
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/

class MyQueue {

    /**
    A 2-stack approach is used to implement a queue using stack.
    We always push to the pushStack and pop or peek from the popAndTopStack. 
    */

    private Stack<Integer> pushStack;
    private Stack<Integer> popAndTopStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        pushStack = new Stack<>();
        popAndTopStack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        // Push is straightforward. Just push to the top of the pushStack
        pushStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        /**
        Approach:
        - First check if both stacks are empty. If so, nothing to be popped so return 
          Integer.MAX_VALUE.
        - Check if the popAndTopStack is empty. If so, pop all elements from pushStack
          and push it into the popAndTopStack.
        - Finally, pop the top element from the popStack.
        */
        if (empty()) {
            return Integer.MAX_VALUE;
        }
        if (popAndTopStack.isEmpty()) {
            while(!pushStack.isEmpty()) {
                popAndTopStack.push(pushStack.pop());
            }
        }
        return popAndTopStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        /**
        Same approach as pop(). 
        Instead of popping the top element from popAndTopStack, just peek.
        */ 
        if (empty()) {
            return Integer.MAX_VALUE;
        }
        if (popAndTopStack.isEmpty()) {
            while(!pushStack.isEmpty()) {
                popAndTopStack.push(pushStack.pop());
            }
        }
        return popAndTopStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return pushStack.isEmpty() && popAndTopStack.isEmpty();
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

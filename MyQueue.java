// Time Complexity : Worse case Time Complexity: O(n) Amortized or Average case complexity: O(1) 
// Space Complexity : O(2n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach : Create two stacks and push all the elements in first stack. 
// For peek operation, if the out stack is empty push all the elements from in stack to out stack and perform peek operation on out stack
// For pop operation, perform peek operation to take care of transferring elements from in to out stack and then perform pop on out stack
// For empty operation, check if in and out stack is empty
class MyQueue {
    private Stack<Integer> in;
    private Stack<Integer> out;
    /** Initialize your data structure here. */
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        // Push all the elements in in stack first
        in.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // Perform peek to shift all the elements
        peek();
        // Return top element from out stack
        return out.pop();        
    }
    
    /** Get the front element. */
    public int peek() {
        // If out stack is Empty push all the elements from in stack into out stack and then get top element from out stack
        while(out.isEmpty()) {
            while(!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        // Queue will be empty only when both the stacks are empty
        return in.isEmpty() && out.isEmpty();        
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

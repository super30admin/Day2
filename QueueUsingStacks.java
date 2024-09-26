/**
 * TC: Push - O(1), Pop - O(N), Peek - O(N), Empty - O(1)
 * SC: O(N)
 * Approach: Queue is FIFO, Stack is LIFO (reverse)
 *  Maintain two stacks in and out
 *  Use in stack for push operation and use out stack for pop and peek operation
 *  Empty the in stack entirely into out stack when the out stack is empty for pop and peek operation
 *  Queue is empty when both the stacks are empty
 */

class MyQueue {

    Stack<Integer> in;
    Stack<Integer> out;
    /** Initialize your data structure here. */
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return out.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        // Empty the in stack entirely into out stack when the out stack is empty
        if(out.isEmpty()) {
            while(!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        
        return out.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        // Queue is empty when both the stacks are empty
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

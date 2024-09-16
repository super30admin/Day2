// Time Complexity :
// push : O(n)
// pop : O(1)
// peek : O(1)
// empty: O(1); 

// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MyQueue {
    
    // We are using two stack approach to implement queue.
    // s1 will contain the elements in FIFO order.
    // s2 will be used as an auxilary stack for maintaining order in s1.
    
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        // if s1 is empty, we push into s1
        if(s1.isEmpty()) {
            s1.push(x);
        } else {
            // s1 is not empty
            // transfer the elements from s1 to s2
            
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            
            // Push new element at the bottom
            s1.push(x);
            
            // Transfer back the elements from s2
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!s1.isEmpty()) {
            return s1.pop();
        }
        
        return -1;
    }
    
    /** Get the front element. */
    public int peek() {
        if (!s1.isEmpty()) {
            return s1.peek();
        }
        
        return -1;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
}
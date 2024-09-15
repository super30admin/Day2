// Time Complexity : Push O(1), Pop O(n), Peek:O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
//Appraoch: Using two stacks. One to queue and another to Dequeue.
class Queue{
    
    Stack <Integer> enqueue;
    Stack <Integer> dequeue;
    /** Initialize your data structure here. */
    public MyQueue() {
        enqueue = new Stack ();
        dequeue = new Stack ();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        enqueue.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (dequeue.empty()) {
            while (!enqueue.empty()) {
                dequeue.push (enqueue.pop());
            }   
           return (int) dequeue.pop();
        } 
        
        return dequeue.pop();
        
        
    }
    
    /** Get the front element. */
    public int peek() {
        if (dequeue.empty()) {
            while (!enqueue.empty()) {
                dequeue.push (enqueue.pop());
            }
            return dequeue.peek();
        }
        return dequeue.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return enqueue.empty() && dequeue.empty();    
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
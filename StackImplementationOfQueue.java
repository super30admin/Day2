// Time Complexity : O(1) for all funtions
// Space Complexity : O(n) where n is the size of the queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class MyQueue {

    /** Initialize your data structure here. */
    
    Deque<Integer> in, out;
    public MyQueue() {
        in = new ArrayDeque(); 
        out = new ArrayDeque();
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
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
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
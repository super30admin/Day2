// Time Complexity : push: O(1), pop: O(n), peek: O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyQueue {
    Stack<Integer> first;
    Stack<Integer> second;

    /** Initialize your data structure here. */
    public MyQueue() {
         first = new Stack();
         second = new Stack();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        first.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        int val = second.pop();
        return val;
    }
    
    /** Get the front element. */
    public int peek() {
        if(second.isEmpty()){
            while(!first.isEmpty()){
                second.push(first.pop());
            }
        }
        
        return second.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (first.isEmpty() && second.isEmpty());
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
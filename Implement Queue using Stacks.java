// Time Complexity : O(1) amortized
// Space Complexity : O(n) where n is the number of elements in the stacks
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyQueue {

    /** Initialize your data structure here. */
    //Two stacks beginning Queue and end queue representing the queue.
    Stack<Integer> begQ;
    Stack<Integer> endQ;
    public MyQueue() {
        begQ = new Stack<>();
        endQ = new Stack<>();
        
    }
    
    /** Push element x to the back of queue. */
    // Push elements to begQ
    //TC: O(1) 
    public void push(int x) {
        begQ.push(x);
        
        
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    // Pop elements from begQ to endQ and pop endQ to get the popped element. Pop from 'begQ' and push to 'endQ' only when endQ is empty.
    //TC: O(1) amortized averagely as initial pop from endQ requires O(n) [as we have to push elements to endQ that are popped from begQ
    // but rest requires O(1) until endQ is empty.
    public int pop() {
        if(endQ.isEmpty()){
            while(!begQ.isEmpty()){
                endQ.push(begQ.pop());
            }
            
        }
        return endQ.pop();
        
    }
    
    /** Get the front element. */
    // Same as pop
    //TC: O(1) amortized similar to pop().
    public int peek() {
        if(endQ.isEmpty()){
            while(!begQ.isEmpty()){
                endQ.push(begQ.pop());
            }
            
        }
        return endQ.peek();
        
    }
    
    /** Returns whether the queue is empty. */
    //TC: O(1) only checking loop
    public boolean empty() {
        return begQ.isEmpty() && endQ.isEmpty();
        
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
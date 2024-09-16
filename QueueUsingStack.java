// Time Complexity :O(N) amortized to O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class MyQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    /** Initialize your data structure here. */
    public MyQueue() {
        stackIn = new Stack();
        stackOut = new Stack();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stackIn.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stackOut.isEmpty()){
            while(!stackIn.isEmpty()){
                int temp = stackIn.pop();
                stackOut.push(temp);
            }
        }
        return stackOut.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(stackOut.isEmpty()){
            while(!stackIn.isEmpty()){
                int temp = stackIn.pop();
                stackOut.push(temp);
            }
        }
        return stackOut.peek();
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stackOut.isEmpty()){
            while(!stackIn.isEmpty()){
                int temp = stackIn.pop();
                stackOut.push(temp);
            }
        }
        return stackOut.isEmpty();
        
    }
}
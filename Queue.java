// Time Complexity : O(1) amortised. Each element is pushed and popped exactly 2 times so O(2) which makes it O(1).
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : leetcode said my space usage was better than just 5% of submissions. This 
// makes me think how can I make it better without trading off the time complexity.


class Queue {
    
    Stack<Integer> inputStack;
    Stack<Integer> outputStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        inputStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return outputStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(!outputStack.isEmpty()) {
            return outputStack.peek();
        } else {
            while(!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
            
            return outputStack.peek();
        }
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
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
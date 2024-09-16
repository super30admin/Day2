// Time Complexity :
// push() - O(1)
// pop() - O(1) amortized
// peek() - O(1) amortized

// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyQueue {
    Stack<Integer> primaryStack;
    Stack<Integer> secondaryStack;

    // Initializing 2 stacks
    public MyQueue() {
        primaryStack = new Stack<Integer>();
        secondaryStack = new Stack<Integer>();
    }
    
    // Pushing given value into primary stack
    public void push(int x) {
        primaryStack.push(x);
    }
    
    // popping value
    public int pop() {
        // if secondary stack is empty transfer everything in primary to secondary stack
       if(secondaryStack.isEmpty()) {
           while(!primaryStack.isEmpty()) {
               secondaryStack.push(primaryStack.pop());
           }
       } 
    //    pop from secondary stack
        return secondaryStack.pop();
    }
    

    public int peek() {
        // if secondary stack is empty transfer everything in primary to secondary stack
        if(secondaryStack.isEmpty()) {
           while(!primaryStack.isEmpty()) {
               secondaryStack.push(primaryStack.pop());
           }
       }
    //    peek and return from secondary stack
        return secondaryStack.peek();
    }
    
    // if both the stacks are empty then return true
    public boolean empty() {
        if(primaryStack.isEmpty() && secondaryStack.isEmpty())
            return true;
        return false;
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
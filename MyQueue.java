// Time Complexity : O(1)
// Amortized cost for each operation is O(1)

// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

class MyQueue {
    
    Stack<Integer> input;
    Stack<Integer> output;

    /** Initialize your data structure here. */
    public MyQueue() {
        //create new stacks
        input = new Stack();
        output = new Stack();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        //Always push to input stack
        input.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //While popping first transfer all elemnts from input to output if output is empty
        //than pop from output
        if(output.isEmpty())
            transferInputToOutput();
        return output.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        //While peeking first transfer all elemnts from input to output if output is empty
        //than peek from output
        if(output.isEmpty())
            transferInputToOutput();
        return output.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        //check if both input and output stack are empty
        return input.isEmpty() && output.isEmpty();
    }
    
    public void transferInputToOutput() {
        //transfer elements from input to output stack
            while(!input.isEmpty()) {
                output.push(input.pop());
            }
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

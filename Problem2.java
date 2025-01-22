//used two stacks to implement FIFO queue using stack. created a method to insert elements in the
// output stack in reverse order such that for every peek or pop method the first element that was
// added is removed. Initially faced problem of jumbling up the second stack which led to not all 
// test cases being passed.
// Time Complexity: o(1).
// Space complexity: o(n)


import java.util.Stack;

class MyQueue {
    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }
    
    public void push(int x) {
        inputStack.push(x);
    }
    
    public int pop() {
        shiftStacks();
        return outputStack.pop();
    }
    
    public int peek() {
        shiftStacks();
        return outputStack.peek();
    }
    
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    private void shiftStacks() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
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
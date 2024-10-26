# Design-2

Explain your approach in **three sentences only** at top of your code


## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)

Implemented queue using 2 stacks. To maintain the order of queue, FIFO used 2 stacks. The push operation maintains the order.

class MyQueue {

    Stack<Integer> stack1, stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();   
    }
    
    public void push(int x) {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }
    
    public int pop() {
        return stack1.pop();
    }
    
    public int peek() {
        return stack1.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty();
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

## Problem 2:
Design Hashmap (https://leetcode.com/problems/design-hashmap/)





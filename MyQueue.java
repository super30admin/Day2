// Time Complexity : O(N) for push, O(1) for push and pop
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class MyQueue {
    Stack<Integer> inputStack;
    Stack<Integer> reverseStack;

    public MyQueue() {
        this.inputStack = new Stack<>();
        this.reverseStack = new Stack<>();
    }
    
    public void push(int x) {
        if(!reverseStack.isEmpty()) {
            while(!reverseStack.isEmpty()) {
                inputStack.push(reverseStack.pop());
            }
        }
        inputStack.push(x);
        while(!inputStack.isEmpty()) {
            reverseStack.push(inputStack.pop());
        }
    }
    
    public int pop() {
        return reverseStack.pop();
        
    }
    
    public int peek() {
        return reverseStack.peek();
        
    }
    
    public boolean empty() {
        return reverseStack.isEmpty();
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
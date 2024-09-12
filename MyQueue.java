import java.util.Stack;

// Time Complexity :
// 1. For push, O(1)
// 2. For pop, O(n)
// 3. For peek, O(n)

// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class MyQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    
    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        peek();
        return stack2.pop();
    }
    
    public int peek() {
        if (empty()) return -1;
        
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        
        return stack2.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

// Your code here along with comments explaining your approach

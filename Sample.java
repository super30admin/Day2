// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


import java.util.Stack;

// Your code here along with comments explaining your approach
class MyQueue {

    Stack<Integer> stack1;
    Stack <Integer> stack2;

    public MyQueue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void push(int x) {

        if (stack1.isEmpty()){
            stack1.push(x);
        }
        else{
            while (!this.empty()){
                int x1 = stack1.pop();
                stack2.push(x1);
            }
            stack1.push(x);
            while (!stack2.isEmpty()){
                int y1 = stack2.pop();
                stack1.push(y1);
            }

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


// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 
 
import java.util.*;

class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
         if (stack2.empty()) {
            while (!stack1.empty()) {
              stack2.push(stack1.peek());
              stack1.pop();
          }
        }
        int num = stack2.peek();
        stack2.pop();
        return num;
    }

    public int peek() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.peek());
                stack1.pop();
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return (stack1.isEmpty() && stack2.isEmpty());
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
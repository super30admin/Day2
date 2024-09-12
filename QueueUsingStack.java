/*  Time Complexity : 
    Push - O(1)
    Pop - Average case - O(1)
    Space Complexity : O(n)
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :
    Your code here along with comments explaining your approach
    1. Used 2 stacks - one for push and the other for pop
    2. For push - always push onto stack-1
    3. For pop/peek -
    i. If stack-2 is not empty - directly pop/peek from stack-2 
    ii. Id stack-2 is empty - 
        Pop from stack-1 and push to stack-2, thus the order gets reversed in stack-2
        Then peek or pop stack-2
*/

import java.util.Stack;
public class QueueUsingStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    
    /** Initialize your data structure here. */
    public QueueUsingStack() {
        stack1 = new Stack<>();
        stack1 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
    
    /** Get the front element. */
    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
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
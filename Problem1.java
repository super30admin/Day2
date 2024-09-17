// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> s;
    public MyQueue() {
        stack=new Stack<>();
        s= new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!stack.isEmpty())
            s.push(stack.pop());
        stack.push(x);
        while (!s.isEmpty()) stack.push(s.pop());
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}
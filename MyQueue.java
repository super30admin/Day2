// Time Complexity : Push & Empty => O(1) Pop & Peek => O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode (232): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyQueue {
    Stack<Integer> st;
    Stack<Integer> rev;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        st = new Stack<>();
        rev = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        st.push(x);
    }
    
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (rev.isEmpty()) {
            while (!st.isEmpty()) {
                rev.push(st.pop());
            }
        }
        return rev.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (rev.isEmpty()) {
            while (!st.isEmpty()) {
                rev.push(st.pop());
            }
        }
        return rev.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return rev.isEmpty() && st.isEmpty();
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
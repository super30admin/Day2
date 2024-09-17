// Time Complexity : All operations except push - O(1), push operation - O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I didn't think of maintaining a variable to keep track of the top element. 
// I wrote it in the second version. Can you please mention in the comments later that how should we think of this from the beginning? 
 

// Your code here along with comments explaining your approach
class MyQueue {

    /** I am using 2 stacks to implement one queue. */
    /** Maintaining a variable front to keep track of the first element in the queue. */
    Stack<Integer> s1, s2;
    int front; 
    
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    /** For adding data to the queue, I am using stack s1 and this operation requires O(1) time. */ 
    public void push(int x) {
        if (s1.isEmpty()) {
            front = x;
        }
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    /** To remove an element from the queue I need to make sure it was the first element which was added to the queue. 
     * For that I am popping all the elements from stack s1 and pushing them to stack s2. This way the order of elements reverses,
     * making sure the element that was added first will be deleted first. */
    public int pop() {
        if (s1.isEmpty() && s2.isEmpty()) {
            return -1;
        }
        if (s2.isEmpty()) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    
    /** Get the front element. */
    /** The front element ie the top element would be at the top of stack s2 if s2 is not empty. 
     * Else the variable front will have it's value. */
    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return front;
    }
    
    /** Returns whether the queue is empty. */
    /** Just checking if both the stacks are empty and returning the boolean value of that statement. */
    public boolean empty() {
        return (s1.isEmpty() && s2.isEmpty());
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
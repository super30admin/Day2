// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;		// using 2 stack approach, one stack for push and second for pop
    int front;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();		// initialization
        stack2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if (stack1.isEmpty())		// if new 
            front = x;
        stack1.push(x);			// new element is always pushed to the first stack
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack2.isEmpty())
            while (!stack1.isEmpty())			// we always pop from second stack and keep repopulating it with elements from stack 1
                stack2.push(stack1.pop());
        return stack2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (stack2.isEmpty())
            return front;				// top element is either present on top of stack 2 or in the fron variable
        return stack2.peek();				//  which is filled when a push operation is performed on an empty stack1
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

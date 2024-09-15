//Time Complexity: O(1) for push,peek,empty O(n) - pop
//Space Complexity: O(n) -  number of operations
//Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope

class MyQueue {

    Stack <Integer> stack1;
    Stack <Integer> stack2;
    int front;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
	// check for the first element to be inserted  - front 
        if(stack1.isEmpty())
            front = x;
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
	//check if stack2 is empty. If empty, no pop has happened yet. So add all elements from stack1 to stack2
        if(stack2.isEmpty()) {
          while(!stack1.isEmpty())
              stack2.push(stack1.pop());
        }
         return stack2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
	// Check if Stack2 is empty. If empty, return the front else reeturn the top of the stack2.
        if(!stack2.isEmpty())
            return stack2.peek();
        return front;
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

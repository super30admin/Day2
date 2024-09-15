// Time Complexity : O(1) push, O(1) average pop, O(1) average peek and O(1) isEmpty()
// Space Complexity : O(N) where N is number of elements pushed to stack
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : I did transfer values from s1 to s2 for every push operation before class, but learnt that it is wise to do transfers during pop and not during push due to frequency of transfers. 


/*
1. Always push values to stack1
2. When pop or peek is performed
	i. If stack2 is not empty, remove or return stack2's top 
	ii. If stack2 is empty, transfer from stack1 to stack2 and then return stack2's top
3. If both stack1 and stack2 are empty, then isEmpty() should return true, else false
*/

class MyQueue {

    Stack<Integer> stack1, stack2;
    
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack2.isEmpty()) {
            transfer(stack1,stack2);
        }
        return stack2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(stack2.isEmpty()) {
            transfer(stack1,stack2);
        }
        return stack2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    
    private void transfer(Stack<Integer> stack1, Stack<Integer> stack2) {
        while(!stack1.isEmpty()) 
            stack2.push(stack1.pop());
    }
}

// Implementation before class: 

class MyQueue {

    Stack<Integer> stack1, stack2;
    
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    	// Push all elements in stack1 to stack2
        while(!stack1.isEmpty()) 
            stack2.push(stack1.pop());
        stack1.push(x);
        // Then, push back from stack2 to stack1
        while(!stack2.isEmpty()) 
            stack1.push(stack2.pop());
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	// pop element
        return stack1.isEmpty()?-1:stack1.pop();
    }
    
    /** Get the front element. */
    public int peek() {
    	// peek element
        return stack1.isEmpty()?-1:stack1.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
    	// Check if stack is empty
        if(stack1.isEmpty())
            return true;
        return false;
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
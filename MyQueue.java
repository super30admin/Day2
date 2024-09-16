import java.util.Stack;

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach

class MyQueue {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);		// Push all the elements in to first stack
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack2.isEmpty()){			//if 2nd stack is empty
            while(!stack1.isEmpty())	// and 1st stack is not empty, then pop all elements from first stack and push to 2nd stack
                stack2.push(stack1.pop());
        }
        return stack2.pop();    		// now pop from 2nd stack to remove element from front
    }
    
    /** Get the front element. */
    public int peek() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty())
                stack2.push(stack1.pop());
        }
        return stack2.peek();   
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    
    public static void main(String[] args) {
    	MyQueue queue = new MyQueue();

    	queue.push(1);
    	queue.push(2);  
    	System.out.println("returns "+queue.peek());
    	System.out.println("returns "+queue.pop());
    	System.out.println("returns "+queue.empty());
    }
}
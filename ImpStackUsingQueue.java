// Time Complexity : For all operations, it is Amortized O(1)
// Space Complexity : O(n), as we are using extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyQueue {

	// Implementing 2 stacks stackIn and stackOut
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;
    
    /** Initialize your data structure here. */
    public MyQueue() {
		
		// Initializing 2 stacks
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
		// push the element onto stackIn
        stackIn.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // if(stackOut.isEmpty()){
        //     while(!stackIn.isEmpty()){
        //         stackOut.push(stackIn.pop());
        //     } 
        // }
		// calling peek function and return popped value of stackOut
        peek();
        return stackOut.pop();
    }
    
    /** Get the front element. */
    public int peek() {
		// Check stackOut is empty, if yes pop all elements from stackIn and add onto stackOut. Return stackOut top element
        if(stackOut.isEmpty()){
            while(!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
		// check if stackIn and stackOut are empty
        return (stackIn.isEmpty() && stackOut.isEmpty());
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
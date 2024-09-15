// Time Complexity : push - O(n); pop - O(1); peek - O(1); isEmpty - O(1);
// Space Complexity : O(n) for both stacks
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyQueue {
    
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
	// use S2 as auxiliary data structure to hold S1 elements and push in newest element as last in order
    public void push(int x) {
      
        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s2.push(x);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
	//Pops element in S1
    public int pop() {
        return s1.pop();
        
    }
    
    /** Get the front element. */
	
    public int peek() {
        return s1.peek();
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
        
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

// Your code here along with comments explaining your approach

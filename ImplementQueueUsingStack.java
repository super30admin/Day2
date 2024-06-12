package design2;

import java.util.Stack;

//Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)
//Time Complexity : O(1)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack1=new Stack<Integer>();
        stack2=new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);		
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int val=0;
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());	//puts all elements one by one from stack1 to stack2
        }
        val=stack2.pop();	//pops the value of the top of the stack i.e. it'd be the value of the front element of the queue
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());	//puts all the elements one by one from stack2 to stack1 to obtain original stack
        }
        return val;
    }
    
    /** Get the front element. */
    public int peek() {
        int val=0;
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());  //puts all elements one by one from stack1 to stack2
        }
        val=stack2.peek();			//stores the value of the top of the stack i.e. it'd be the value of the front element of the queue
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());	//puts all the elements one by one from stack2 to stack1 to obtain original stack
        }
        return val;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
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

//Your code here along with comments explaining your approach
public class ImplementQueueUsingStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue mQueue=new MyQueue();
		mQueue.push(1);
		mQueue.push(2);  
		System.out.println(mQueue.peek());  // returns 1
		System.out.println(mQueue.pop());   // returns 1
		System.out.println(mQueue.empty()); // returns false
	}

}

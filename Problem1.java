//PROBLEM - Implement Queue using 2 stacks 
/** 3 Pointer Approcach: 
 * 2 stacks are taken.
 * 1st stack will be updated on each Push operation.
 * 2nd stack willhandle all Peek and Pop operations.
 * WhenEver a pop/peek operation is made 2nd stack will be checked -
 * if 2nd stack is empty then all elements present in 1st stack will 
 * be inserted to 2nd stack and then Peek or Pop us performed.
 */ 
//
//time Complexity :
// Push - Best/Amotized/Worst:O(1)
// Pop - Best/Amotized:O(1); Worst: O(N)
// Peek - Best/Amotized:O(1); Worst: O(N)


// Space Complexity :
// O(N), where N is the number of elements

// Did this code successfully run on Leetcode : YES.
// Any problem you faced while coding this : NO, However, please let me know wheather I am calculating time complexity in the right way. 


import java.util.Stack;

public class Problem1 {
    
}class MyQueue {

    Stack<Integer> stack1 = new Stack<Integer>(); // 1st Stack - All Push operations
    Stack<Integer> stack2 = new Stack<Integer>(); // 2nd Stack - All Pop/Peek operations
        
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x); // push always in 1st stack
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop()); // pop always from 2nd stack
            }
        }
        
        return stack2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop()); // peek always from 2nd stack
            }
        }
        
        return stack2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty(); // Self Explationatory
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
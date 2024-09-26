import java.util.Stack;

// Time Complexity : O(1) for push operations, O(N) a costly pop operation. 
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES, 100% efficiency
// Any problem you faced while coding this : NO 


// Your code here along with comments explaining your approach
/* 
Approach:
1) consider 2 stacks
2) once the element is pushed in one stack, to emulate a queue, we pop all the elements from stack1 and push them to stack2
3) once that is completed, we just peek() and get the element
4) thus push results in O(1) operation while pop operation is costly and is O(N) as there can be N elements pushed from stack1 to stack2



*/


class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;
    
    
    /** Initialize your data structure here. */
    public MyQueue() {
        
        stack1= new Stack();
        stack2= new Stack();
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        
        stack1.push(x);
        
       
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        
        if(stack2.isEmpty())
        {
             while(!stack1.isEmpty())
            {
                stack2.push(stack1.pop());
            }
        }
        return !stack2.isEmpty() ? stack2.pop() :-1;
        
    }
    
    /** Get the front element. */
    public int peek() {
        
        if(stack2.isEmpty())
        {
             while(!stack1.isEmpty())
            {
                stack2.push(stack1.pop());
            }
        }
        return !stack2.isEmpty() ? stack2.peek() : -1;
        
        
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
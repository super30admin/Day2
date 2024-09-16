// Time Complexity : O(1) amortized because of pop operation and peek operation
// Space Complexity : O(N) //just a guess, ****not clear why
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : in peek operation, I had put if(!stack1.isEmpty()) which lead to incorrect result. 

/** Approach:
 * we maintain two stacks: stack1 and stack2 where stack2 is used for pop and peek operations. stack1 is used to push elements into the queue.
 * for pop operation, we need first element in the queue. so, we transfer all elements from stack1 to stack2 in case stack2 is empty and then return the top element of stack2. if stack2 is not empty, return stack2.pop().
 * for peek operation, we need to see if stack2 is empty, if yes then simply return top element of stack2 , else, we need to transfer elements from stack1 to stack2 and then return top element of stack2.
 * for empty function, we need to check if both stacks are empty, if yes, then return true else return false. 
 */

import java.util.*;
class MyQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    /** Initialize your data structure here. */
    public MyQueue() {
        
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
        return stack2.pop();
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
        return stack2.peek();
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stack1.isEmpty() && stack2.isEmpty()) return true;
        return false;
    }
    public static void main(String[] args)
    {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.peek());
        obj.push(3);
        System.out.println(obj.peek());
        System.out.println(obj.empty());
    }
}

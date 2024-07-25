// Time Complexity : O(1) amortized.
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : The usage of two stacks to invert the LIFO process was hard at first.


/**
* Implement queue using 2 stacks
* 1st stack acts as actual stack performing input.
* 2nd stack acts as actual queue. I am interested in this, since this will output my results.
*/

import java.util.Stack;


class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> queue;

    public MyQueue() {
        stack = new Stack<Integer>();
        queue = new Stack<Integer>();
    }
    
    // Just collects my input. I am not going to display this as output.
    public void push(int x) {
        stack.push(x);// Last In First out
        
    }
    
    public int pop() {
        // This if condition exists for the following-
        // for eg -input  1,2,3,4
        // stack becomes = 4,3,2,1 (from the top)
        // queue becomes = 1,2,3,4 (from the top)
        // Now, if I insert 5 in the queue through the LIFO mechanism, there is a problem, since the last element is 5 which becomes the first element, which is wrong 
        if(queue.isEmpty()) {
            while(!stack.isEmpty()) {// empties all data in queue
                queue.push(stack.pop());
            }
        }
        return queue.pop();
    }
    
    public int peek() {
        if(queue.isEmpty()) {
            while(!stack.isEmpty()) {
                queue.push(stack.pop());
            }
        }
        return queue.peek();
    }
    
    // Both stacks need to be checked.
    public boolean empty() {
        return stack.isEmpty() && queue.isEmpty();
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
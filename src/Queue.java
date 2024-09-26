// Time Complexity : push : O(1) , pop : O(n), peek :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach
/**
 * Implemented 2 stacks to design queue data structure.
 * Push will use stack push method to add elements into the queue.
 * To pop first element, had to move all elements to another stack and remove the first element.
 * To peek, the same approach as pop but will not remove the pop method to remove the topmost element.
 */

import java.util.Stack;

class Queue {

    /** Initialize your data structure here. */
    Stack<Integer> stk1,stk2;

    public Queue() {
        stk1 = new Stack<Integer>();
        stk2 = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stk1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!stk1.isEmpty())
            stk2.push(stk1.pop());
        int returnedele =  stk2.pop();
        while(!stk2.isEmpty())
            stk1.push(stk2.pop());
        return returnedele;
    }

    /** Get the front element. */
    public int peek() {
        while(!stk1.isEmpty())
            stk2.push(stk1.pop());
        int returnedele =  stk2.peek();
        while(!stk2.isEmpty())
            stk1.push(stk2.pop());
        return returnedele;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stk1.isEmpty();
    }
}

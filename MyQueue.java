// Time Complexity : O(1) for all the operations
// Space Complexity : O(n) for push, amortized O(1) for pop and O(1) for other opeations like peek and isEmpty
// Did this code successfully run on Leetcode : Yes


class MyQueue {

    /** Declare two stacks */
    Stack<Integer> stk1 = new Stack<>();
    Stack<Integer> stk2 = new Stack<>();

    /** Front element of the queue  */
    int frontElement;


    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {


        /** if stk1 is empty then initialize first element to push as front element */
        if(stk1.isEmpty()) {
            frontElement = x;
        }

        stk1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {

        /** if stk2 is empty transfer all elements from stk1 to stk2 so that the first element of the queue to pop is on the top of stk2 */

        if(stk2.isEmpty()) {

            while(!stk1.isEmpty()) {
                stk2.push(stk1.pop());
            }

        }

        return stk2.pop();

    }

    /** Get the front element. */
    public int peek() {

        /** Front element is on the top of stk2 which is the peek element*/

        if(!stk2.isEmpty()) {
            return stk2.peek();
        }

        return frontElement;

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {

        /**  Check both the stacks whether they are empty as both have elements  */

        return stk1.isEmpty() && stk2.isEmpty();

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
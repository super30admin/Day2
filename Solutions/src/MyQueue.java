// Time Complexity :
//Push O(1)
//Peek O(n) (Push all elements from one stack to another)
//Pop O(n) (Push all elements from one stack to another)
//Empty O(1)
// Space Complexity : O(n) + O(m) = O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//Created 2 Stacks , push ops are easy. Simply add items to stack.
//As this is a Queue made out of stack (FIFO has to be followed). So for pop and peek, all the elements from S1 are transfered to S2. And then popped from S2.
//The empty check is done on both the stacks.

import java.util.Stack;

class MyQueue {
    Stack<Integer> S1;
    Stack<Integer> S2;
    /** Initialize your data structure here. */
    public MyQueue() {
        S1 = new Stack<>();
        S2 = new Stack<>();
    }
    private void transfer(Stack S1, Stack S2){
        while (!S1.isEmpty()){
            S2.push(S1.pop());
        }
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        S1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (S2.isEmpty()){
            transfer(S1,S2);

        }
        return S2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (S2.isEmpty()){
            transfer(S1,S2);
        }
        return S2.peek();

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return S1.isEmpty() && S2.isEmpty();
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
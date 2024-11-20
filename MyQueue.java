// Amortized Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// 1. We use 2 stacks to keep a track of the element.
// 2. Since queue uses a FIFO approach and stack uses a LIFO approach, we use two stacks.
// 3. In stack keeps track of all the incoming elements.
// 4. Out stack keeps track of all the outgoing elements.
// 5. whenever we push an element, we push it to the in stack.
// 6. when we want to pop an element, we pop all it from the out stack and return it.
// 7. If the out stack is empty at the time of pop, then we pop all elements from ins tack and place it in out stack.
//    This transfer of objects from in stack to out stack reverses the LIFO functionality to FIFO.

import java.util.Stack;

class MyQueue {
    
    Stack<Integer> instack;
    Stack<Integer> outstack;

    /** Initialize your data structure here. */
    public MyQueue() {
        instack = new Stack<Integer>();
        outstack = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        instack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return outstack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(!outstack.isEmpty()) return outstack.peek();
        while(!instack.isEmpty()){
            outstack.push(instack.pop());
        }
        return outstack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return instack.isEmpty() && outstack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(5);
        obj.push(9);
        obj.push(2);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }
}
// Time Complexity :-
//      Pop - O(1)
//      Push - O(1)
//      Peek - O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    We make use of two stacks to implement a Queue, the first one is used to push, the second one to pop.
    The elements are transferred as and when required.
*/

class MyQueue {

    Stack<Integer> stackOne;
    Stack<Integer> stackTwo;
    
    public MyQueue() {
        stackOne = new Stack<>();
        stackTwo = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stackOne.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return stackTwo.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(stackTwo.isEmpty())
            while(!stackOne.isEmpty()) stackTwo.push(stackOne.pop());
        return stackTwo.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackOne.isEmpty() && stackTwo.isEmpty();
    }
}

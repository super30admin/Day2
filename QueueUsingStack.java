// Time Complexity : Push -> O(1)
//                   Pop -> O(N)
//                   Peek -> O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach
// I'm adding the element to the top of the stack, as if it were the tail of a queue,
// but for the pop/peek operation, I'm transferring all the elements to a secondary stack,
// popping/peeking the top element, and again tranferring all the elements back to the primary stack.
// For each operation the elements are tranfeered to and fro twice, i.e. 2N times.

class MyQueue {

    private Stack<Integer> primary;
    private Stack<Integer> secondary;

    /** Initialize your data structure here. */
    public MyQueue() {
        primary = new Stack<>();
        secondary = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        primary.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int popped;
        while (!primary.isEmpty())
            secondary.push(primary.pop());
        popped = secondary.pop();
        while (!secondary.isEmpty())
            primary.push(secondary.pop());
        return popped;
    }

    /** Get the front element. */
    public int peek() {
        int peekElement;
        while (!primary.isEmpty())
            secondary.push(primary.pop());
        peekElement = secondary.peek();
        while (!secondary.isEmpty())
            primary.push(secondary.pop());
        return peekElement;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return primary.size() <= 0;
    }
}

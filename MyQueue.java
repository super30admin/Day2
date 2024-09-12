
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

import java.util.Stack;

/**
 * Implemented Queue(First In First Out) DS using two stacks.
 */
public class MyQueue {
    Stack<Integer> pushStack;
    Stack<Integer> popStack;

    public MyQueue() {
        pushStack = new Stack();
        popStack = new Stack();
    }

    /**
     * Push element x to the back of queue.
     * @param x
     */
    //Time complexity:o(1). In worst case it will be 0(n)
    //Space complexity:o(1)
    public void push(int x) {
        pushStack.push( x );
    }

    /**
     * Removes the element from in front of queue.
     * @return
     */
    //Time complexity:o(1). In worst case it will be 0(n)
    //Space complexity:o(1)
    public int pop() {
        peek();
        return popStack.pop();

    }

    /**
     * Get the front element.
     * @return
     */
    //Time complexity:o(1).
    //Space complexity:o(1)
    public int peek() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push( pushStack.pop() );
            }
        }
//        if(popStack.isEmpty()) return -1;// if peek used on empty stack
        return popStack.peek();

    }

    /**
     * Return whether the queue is empty.
     * @return
     */
    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();

    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        System.out.println(queue.empty());// returns true
        queue.push( 1 );
        System.out.println( queue.peek());// returns 1
        System.out.println(queue.pop()); // returns 1
        System.out.println(queue.empty());// returns false
        queue.push( 2 );
        queue.push( 3 );
        queue.push( 4 );
        queue.push( 25);
        System.out.println(queue.pop()); // returns 2

    }
}

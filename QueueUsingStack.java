// Time Complexity : push O(1) 
//                   pop  O(1)
//                   peek O(1)
// Space Complexity : O(2n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No, but in the beginning I implmented this solution such that where time comlexity of pop and peek operation was O(n).

import java.util.Stack;

class MyQueue {
    Stack<Integer> firstSt;
    Stack<Integer> secondSt;
    /** Initialize your data structure here. */
    public MyQueue() {
        firstSt = new Stack<>();
        secondSt = new Stack<>();

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        //pushing the element on the top of the stack
        firstSt.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //check the element exist in the second stack, it it does then pop it
        peek();
        return secondSt.pop();
    }
    /** Get the front element. */
    public int peek() {

        //Push the elements from first to second stack(if stack is empty)inorder top get element from the  front
        if(secondSt.isEmpty()) {
            while(!firstSt.isEmpty())
                secondSt.push(firstSt.pop());
        }
        return secondSt.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return firstSt.isEmpty() && secondSt.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(5);
        obj.push(4);
        obj.push(6);
        System.out.println("Popped element is " + obj.pop());
        System.out.println("Element which is in the front of the queue is :"+obj.peek());
        System.out.println("Stack is empty or not: " + obj.empty());
    }
}


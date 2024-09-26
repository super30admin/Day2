package com.design2;


import java.util.Stack;

class MyQueue {

    private Stack<Integer> input = new Stack<>();
    private Stack<Integer> output = new Stack<>();


    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(output.isEmpty()){
            shiftStacks();
        }
        return output.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(output.isEmpty()){
            shiftStacks();
        }
        return output.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }


    public void shiftStacks(){
        while(!input.isEmpty()){
            output.push(input.pop());
        }
    }

    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2]
        myQueue.empty(); // return false

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
// Time Complexity : 0(1)
// Space Complexity : 0(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : It is not popping the first elem, it is still poping and peeking the top element


import java.util.Stack;

class MyQueue {

    Stack<Integer> st1; //Created a stack to push the incoming keys
    Stack<Integer> st2; //Created a stack to reverse the sequence of keys for pop and peak

    public MyQueue() {
        this.st1 = new Stack<>();
        this.st2 = new Stack<>();
    }

    public void push(int x) {

        st1.push(x); //Pushes key in the first element

    }

    public int pop() {
        if(st2.empty() && !st1.empty()){ //If stack 2 is empty and stack 1 is not empty
            while(!st1.empty()){
                st2.push(st1.pop()); //Keys from stack 1 will be pushed into stack 2 in a reverse order
            }
        }

        return st2.pop(); //Removes the top element of stack 2 which is the first element in the queue


    }

    public int peek() {
        if(st2.empty() && !st1.empty()){ //If stack 2 is empty and stack 1 is not empty
            while(!st1.empty()){
                st2.push(st1.pop()); //Keys from stack 1 will be pushed into stack 2 in a reverse order
            }
        }

        return st2.peek(); //Returns the top element of stack 2 which is the first element in the queue
    }


    public boolean empty() {

        return st1.empty() && st2.empty(); // Returns true if both the stacks are empty

    }
}

/**
 // * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
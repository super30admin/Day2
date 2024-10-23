// Time Complexity : empty: O(1)
//                   push: O(1)
//                   pop: O(1)
//                   peek: O(1)
// Space Complexity : empty: O(1)
//                    push: O(1)
//                    pop: O(1)
//                    peek: O(1)
//                    constructor: O(2n) because we're creating stacks
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

import java.util.Stack;

class MyQueue {
        Stack<Integer> inStk;
        Stack<Integer> outStk;
    public MyQueue() {
        this.inStk= new Stack<>();
        this.outStk= new Stack<>();
    }

    public void push(int x) {
        inStk.push(x);
    }

    public int pop() {
        if(empty()) return -1;
        if(outStk.isEmpty()){
            while(!inStk.isEmpty()){
                outStk.push(inStk.pop());
            }
        }
        return outStk.pop();
    }

    public int peek() {
        if(outStk.isEmpty()){
            while(!inStk.isEmpty()){
                outStk.push(inStk.pop());
            }
        }
        return outStk.peek();
    }

    public boolean empty() {
        return inStk.isEmpty() && outStk.isEmpty();
    }


    public static void main(String args[])
    {
        MyQueue queue = new MyQueue();
        queue.push(10);
        queue.push(20);
        queue.push(30);
        queue.push(9);
        queue.push(7);
        queue.push(6);
        System.out.println(queue.pop() + " Popped from stack");
        System.out.println(queue.peek() + " is top element of the stack");
    }
}

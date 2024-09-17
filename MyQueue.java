
// Time Complexity : Add : O(1)  Pop : O(N)  Peek : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;

public class MyQueue {
    //Creating 2 stacks. one for push and one for pop
    private Stack<Integer> push_stack;
    private Stack<Integer> pop_stack;

    public MyQueue() {
        push_stack = new Stack();
        pop_stack = new Stack();
    }

    public void push(int x) {
        // Simply push values in push_stack
        push_stack.push(x);
    }

    public int pop() {
        //If pop stack is empty, call shift_stack function
        if(pop_stack.isEmpty())
            shift_stack();

        //return the last element
        return pop_stack.pop();
    }

    public int peek() {
        if(pop_stack.isEmpty())
            shift_stack();

        return pop_stack.peek();
    }

    public boolean empty() {
        // Check if both stacks are empty
        return push_stack.isEmpty() && pop_stack.isEmpty();
    }

    public void shift_stack(){
        //Copy all elements from push_stack to pop_stack
        while(!push_stack.isEmpty()){
            int item = push_stack.pop();
            pop_stack.push(item);
        }
    }

    public static void main(String[] args) {
         MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}


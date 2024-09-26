// Time Complexity: O(1)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

import java.util.Stack;

class MyQueue {
    Stack<Integer> push_stack;
    Stack<Integer> pop_stack;

    public MyQueue() {
        // Initilizing two stack push & pop stacks
        push_stack = new Stack<Integer>();
        pop_stack = new Stack<Integer>();
    }

    public void push(int x) {
        // Pushing into push stack
        push_stack.push(x);
        System.out.println("Pushed element: " + (x));
    }

    public int pop() {
        // Checking if pop stack has value for that calling peek function
        peek();
        // poping element from pop stack
        return pop_stack.pop();
    }

    public int peek() {
        // checking if pop stack is empty, 
        // if empty then taking element from push stack and adding in pop stack
        if (pop_stack.isEmpty()) {
            while (!push_stack.isEmpty()) {
                pop_stack.push(push_stack.pop());
            }
        }
        System.out.println("Pick element: " + (pop_stack.peek()));
        // returning peek element from pop stack
        return pop_stack.peek();
    }

    public boolean empty() {
        System.out.println("is empty: " + (pop_stack.isEmpty() && push_stack.isEmpty()));
        // returning true if both stacks are empty
        return pop_stack.isEmpty() && push_stack.isEmpty();
    }
}

public class Queue {
    public static void main(String[] args) {

        // Driver code
        MyQueue obj = new MyQueue();
        obj.push(3);
        obj.push(2);
        obj.pop();
        obj.peek();
        obj.empty();
    }
}

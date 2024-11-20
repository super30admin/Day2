import java.util.Stack;

// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no

class MyQueue {
    Stack<Integer> in; // creating in stack
    Stack<Integer> out; // creating out stack

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();

    }

    public void push(int x) {
        in.push(x);

    }

    public int pop() {
        if (out.isEmpty()) { /*
                              * Checking if the out stack is empty and if it is moving elements from in-stack
                              * to out-stack and poppoing the topmost element of the out-stack.
                              */
            while (!in.isEmpty()) {
                out.push(in.pop());
            }

        }
        return out.pop();

    }

    public int peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) { // same logic as pop, but return out.peek().
                out.push(in.pop());
            }

        }
        return out.peek();

    }

    public boolean empty() {
        return (in.isEmpty() && out.isEmpty()); // queue is empty only if both the stacks are empty.

    }

    public static void main(String args[]) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.pop();
        obj.peek();
        obj.empty();
    }

}

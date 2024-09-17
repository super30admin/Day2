import java.util.Stack;

class MyQueue {

    // Did this code successfully run on Leetcode : YES
    // Any problem you faced while coding this : NO

    // created "in" stack for o(1) pushes and out stack for O(1) pops
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();

    }

    // Time Complexity :O(1)
    // Space Complexity : O(n)
    public void push(int x) {
        in.push(x);

    }

    // Time Complexity :O(1)
    // Space Complexity : O(n)
    public int pop() {
        // if out stack is empty push all the elements of in stack into out stack. pop
        // the element form out stack.
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();

    }

    // Time Complexity :O(1)
    // Space Complexity : O(n)
    public int peek() {
        // if out stack is empty push the elements from in to out and using peek
        // function return the top element of the out stack
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();

    }
    // Time Complexity :O(1)

    public boolean empty() {
        // return weather the in and out stack both are empty.
        return in.isEmpty() && out.isEmpty();

    }
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
 * obj.peek(); boolean param_4 = obj.empty();
 */
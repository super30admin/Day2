/// Here I am using two stacks to implement the Queue. The first stack initially takes all the lements that is being pushed on to the stack. 
// But when a pop or a peek function is encountered, the elements from first stack is put into the second stack, and elements from second stack will be
// returned back to the user as top/popped element. 

// Time Complexity : O(1) amortised for pop and peek, O(1) for push operation
// Space Complexity : O(1)

import java.util.Stack;

public class MyQueue {

    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if (empty())
            return -1;
        peek();
        return out.pop();
    }

    public int peek() {
        if (empty())
            return -1;

        if (!out.isEmpty()) {
            return out.peek();
        }
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
        return out.peek();
    }

    public boolean empty() {
        return in.empty() && out.empty();
    }
}

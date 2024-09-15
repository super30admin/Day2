
/*
Time: Push O(1), Pop O(1), Peek O(1)
Space: O(n) - Space for 2 stacks
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None

*/
import java.util.Stack;

class MyQueue {

    private Stack<Integer> input;
    private Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);

    }

    public int pop() {
        if (output.isEmpty())
            shiftStacks();

        return output.pop();
    }

    public int peek() {
        if (output.isEmpty())
            shiftStacks();

        return output.peek();

    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    public void shiftStacks() {
        while (!input.isEmpty()) {
            output.push(input.pop());
        }
    }
}

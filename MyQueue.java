import java.util.Stack;
//Time complexity is O(1) in push , empty, pop and peek is amortized O(1)
//Code ran successfully on leetcode platform
//Space complexity : O(n)
class MyQueue {

    Stack<Integer> input;
    Stack<Integer> output;
    public MyQueue() {
        this.input = new Stack<>();
        this.output = new Stack<>();
    }

    public void push(int x) {
        this.input.push(x);
    }

    public int pop() {
        peek();
        return this.output.pop();
    }

    public int peek() {
        if (this.output.isEmpty()){
            while (!this.input.isEmpty()){
                this.output.push(this.input.pop());
            }
        }
        return this.output.peek();
    }

    public boolean empty() {
        return this.output.isEmpty() && this.input.isEmpty();
    }
}

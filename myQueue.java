import java.util.Stack;

class MyQueue {

    // declare two stacks one is input and another is output stack
    private Stack<Integer> ip;
    private Stack<Integer> op;

    public MyQueue() {

        // intialize stacks
        ip = new Stack<>();
        op = new Stack<>();
    }

    public void push(int x) {

        // push element in input stack
        ip.push(x);
    }

    public int pop() {

        // whenever we want to pop element, if output stack is not empty
        // (as whenever elements are avaible in output stack it is already reveresed of
        // input stack) so we pop element from output stack
        if (!op.isEmpty()) {
            return op.pop();
        } else {
            // else we reverse input stack and store it in output stack
            while (!ip.isEmpty()) {
                op.push(ip.pop());
            }
        }

        // return top element and pop it from the output stack
        return op.pop();
    }

    public int peek() {

        // whenever we want to top element, if output stack is not empty
        // (as whenever elements are avaible in output stack it is already reveresed of
        // input stack) so we return top element from output stack
        if (!op.isEmpty()) {
            return op.peek();
        } else {
            // else we reverse input stack and store it in output stack
            while (!ip.isEmpty()) {
                op.push(ip.pop());
            }
        }
        // return top element from the output stack

        return op.peek();
    }

    public boolean empty() {

        // check if output stack and input stack is empty
        return op.isEmpty() && ip.isEmpty();
    }

    public static void main(String[] args) {

    }
}
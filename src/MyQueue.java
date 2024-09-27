import java.util.Stack;

public class MyQueue {

    private Stack<Integer> stack;
    private Stack<Integer> temp;
    public MyQueue() {
        stack = new Stack<>();
        temp = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        peek();
        return temp.pop();
    }

    public int peek() {
        if (temp.isEmpty()){
            while (!stack.isEmpty()){
                temp.push(stack.pop());
            }
        }
        return temp.peek();
    }

    public boolean empty() {
        return stack.isEmpty() && temp.isEmpty();
    }
}

public class problem1 {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue() {
        this.stackIn = new Stack<>();
        this.stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        peek();
        return stackOut.pop();
    }

    public int peek() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.peek();
    }

    public boolean empty() {
        if (stackIn.isEmpty() && stackOut.isEmpty()) {
            return true;
        }
        return false;
    }
}

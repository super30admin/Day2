import java.util.Stack;

public class MyQueue {
    Stack<Integer> pushStack;
    Stack<Integer> popStack;

    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    // TC is O(n) on every push
    // SC is O(n)
    public void push(int x) {
        if (!popStack.empty()) {
            while (popStack.size() > 0) {
                pushStack.push(popStack.pop());
            }
            pushStack.push(x);
            while (pushStack.size() > 0) {
                popStack.push(pushStack.pop());
            }
        } else {
            popStack.push(x);
        }
    }

    // TC is O(1)
    public int pop() {
        if (!popStack.empty()) {
            return popStack.pop();
        }
        return -1;
    }

    // TC is O(1)
    public int peek() {
        if (!popStack.empty()) {
            return popStack.peek();
        }
        return -1;
    }

    // TC is O(n)
    public boolean empty() {
        return (popStack.empty() && pushStack.empty()) ? true : false;
    }

    public static void main(String arr[]) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
    }
}

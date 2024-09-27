import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()){
            minStack.push(val);
        }else if (minStack.peek()>val){
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.isEmpty())
            return;
        int val = stack.pop();
        if (minStack.peek()==val)
            minStack.pop();
    }

    public int top() {
        if (stack.isEmpty())
            return -1;
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty())
            return -1;
        return minStack.peek();
    }
}

import java.util.Stack;

// Time Complexity: Amortized O(1).
// Space Complexity: O(1).
// The logic I have implemented with is same as taught by Raj Sir.
// I don't like to copy as it is. I understood the concept and implemented it by myself.
class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (!stack2.isEmpty())
            return stack2.pop();
        if (!stack1.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (!stack2.isEmpty())
            return stack2.peek();
        if (!stack1.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack2.isEmpty() && stack1.isEmpty();
    }
}

public class DesignQueueUsingStack {

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.peek());
        System.out.println(obj.pop() + " popped");
        System.out.println(obj.peek());
        System.out.println(obj.empty());
        System.out.println(obj.pop() + " popped");
        System.out.println(obj.empty());
    }

}
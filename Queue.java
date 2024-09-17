
public class MyQueue {
    /*
     * Time Complexity: O(1) for push, pop, peek and empty. Worst case for traversal for peek & pop O(n)
     * Space Complexity: O(n) --> O(2n) considering two stacks being used
     * Author: Aditya Mulik
     */

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        peek();
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean empty() {
        if (inStack.isEmpty() && outStack.isEmpty()) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.peek();  // returns 1
        queue.pop();   // returns 1
        queue.empty(); // returns false
    }
}

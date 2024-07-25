import java.util.Stack;


class Queue {
    Stack<Integer> myStack;
    Stack<Integer> myQueue;

    public MyQueue() {
        myStack = new Stack<Integer>();
        myQueue = new Stack<Integer>();
    }

    public void push(int x) {
        myStack.push(x);
    }

    public int pop() {
        if(myQueue.isEmpty()) {
            while(!myStack.isEmpty()) {
                myQueue.push(myStack.pop());
            }
        }
        return myQueue.pop();
    }

    public int peek() {
        if(myQueue.isEmpty()) {
            while(!myStack.isEmpty()) {
                myQueue.push(myStack.pop());
            }
        }
        return myQueue.peek();
    }
    public boolean empty() {
        return myStack.isEmpty() && myQueue.isEmpty();
    }
}

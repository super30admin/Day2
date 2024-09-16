import java.util.Stack;

public class MyQueue {

    //We will be using two stacks, the in for pushing and out for popping
    Stack<Integer> in, out;

    /** Initialize your data structure here. */
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }

    //transfer while popping so that the order switches
    private void transfer(Stack<Integer> in, Stack<Integer> out){
        while(!in.isEmpty()){
            out.push(in.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return out.pop();

    }

    /** Get the front element. */
    public int peek() {
        if(out.isEmpty()){
            transfer(in, out);
        }
        return out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}



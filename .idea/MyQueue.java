import java.sql.SQLOutput;
import java.util.Stack;

public class MyQueue {

    Stack<Integer> stack;
    Stack<Integer> q;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
        q = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return q.pop();
    }
    /** Get the front element. */
    public int peek() {
        if(q.empty()) {
            while (!stack.isEmpty()) {
                q.push(stack.pop());
            }
        }
        return q.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.empty() && q.empty();
    }
    public static void main(String args[])
    {
        MyQueue obj = new MyQueue();
        obj.push(4);
        obj.push(5);
        obj.push(6);
        int param_2 = obj.pop();
        System.out.println(param_2);
        int param_3 = obj.peek();
        System.out.println(param_3);
        obj.push(11);
        System.out.println(obj.pop());
        boolean param_4 = obj.empty();
        System.out.println(param_4);
    }
}
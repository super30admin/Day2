import java.util.*;

public class QueueStacks1 {
    Stack<Integer> s1;
    Stack<Integer> s2;

    /** Initialize your data structure here. */
    public QueueStacks1() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        int temp = s2.pop();
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return temp;
    }

    /** Get the front element. */
    public int peek() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        int temp = s2.peek();
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return temp;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();

    }
}

//Time Complexity O(1)
//Space Complexity O(n)

import java.util.Stack;

class MyQueue {

    Stack<Integer> reg;
    Stack<Integer> min;

    public MyQueue() {
        reg = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        reg.push(x);
    }

    public int pop() {
        if (min.isEmpty()) {
            while (!reg.isEmpty()) {
                min.push(reg.pop());
            }
        }
        return min.pop();
    }

    public int peek() {
        if (min.isEmpty()) {
            while (!reg.empty()) {
                min.push(reg.pop());
            }
        }
        return min.peek();
    }

    public boolean empty() {
        return reg.isEmpty() && min.isEmpty();
    }
}
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
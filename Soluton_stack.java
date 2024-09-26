/*
Time Complexity : push : O(1) pop O(1), peek O(1), remove O(1)
Space Complexity:  O(n)

*/

import java.util.Stack;

class MyQueue {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {

        s1.push(x);

    }

    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public int peek() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public boolean empty() {
       
        return s2.isEmpty() && s1.isEmpty();
    }
}

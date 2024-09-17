//time complexity O(1) for push. O(1) for pop..woprst case if 2ns stack is empty then we will have to put all the elements in the stack once which will be o(N)
//Space complexity O(N) using an extra stack
//Leetcode: Yes
//No trouble

import java.util.Stack;
class MyQueue {
    private int peak_element;
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    public MyQueue() {
        this.peak_element = -1;
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    public void push(int x) {
        if (this.s1.isEmpty()) {
            this.peak_element = x;
        }
        this.s1.push(x);
    }

    public int pop() {
        if (this.s2.isEmpty()) {
            while (!this.s1.isEmpty()){
                int val = this.s1.pop();
                this.s2.push(val);
            }
        }
        return this.s2.pop();
    }

    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return this.peak_element;
    }

    public boolean empty() {
        if (this.s1.isEmpty() && this.s2.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        System.out.println("Poped: " + obj.pop());
        System.out.println("Poped: " + obj.pop());
        System.out.println("Peek: " + obj.peek());
        obj.push(5);
        System.out.println("Peek: " + obj.peek());
        System.out.println("Poped: " + obj.pop());
        System.out.println("Poped: " + obj.pop());
        System.out.println("Peek: " + obj.peek());
        System.out.println("Empty : " + obj.empty());
        System.out.println("Poped: " + obj.pop());
        System.out.println("Empty : " + obj.empty());

    }
}


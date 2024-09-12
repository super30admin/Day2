// Time Complexity O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes



package leetcode;

import java.util.Stack;

class Fanng3{
    private Stack<Integer> in;
    private Stack<Integer> out;

    /** Initialize your data structure here. */
    public Fanng3() {
        in = new Stack<>();
        out = new Stack<>();

    }

    /** Push element x to the back of queue. Time Complexity O(1) */
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element.Time Complexity O(N) */
    public int pop() {
        peek();
        return out.pop();
    }

    /** Get the front element.O(N) */
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    /** Returns whether the queue is empty. Time Complexity 0(1)*/
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    public static void main(String[] args) {
        Fanng3  obj = new Fanng3();
        obj.push(3);
        System.out.println(obj.peek());
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
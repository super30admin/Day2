//---------------BRUTE FORCE--------------------
// Time Complexity :pop(),peek()->O(n) where n is no of elements; rest all O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class MyQueue {
    private Stack<Integer> st1;
    private Stack<Integer> st2;

    public MyQueue() {
        this.st1 = new Stack<>();
        this.st2 = new Stack<>();

    }

    public void push(int x) {
        st1.push(x);

    }

    public int pop() {
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }
        int x = st2.pop();
        while (!st2.isEmpty()) {
            st1.push(st2.pop());
        }
        return x;
    }

    // in pop and peek method we'll take out whole stack and return the first
    // inserted value
    public int peek() {
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }
        int x = st2.peek();
        while (!st2.isEmpty()) {
            st1.push(st2.pop());
        }
        return x;
    }

    public boolean empty() {
        return (st1.isEmpty() && st2.isEmpty());
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

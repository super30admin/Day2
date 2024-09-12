// Time Complexity : Push - O(1), Pop - O(n), Peek - O(1), Empty - O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;
    //  Maintaining a front to store peek element of supposed queue
    int front;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        if (s1.isEmpty())
            front = x;

        s1.push(x);
    }

    public int pop() {
        //  s2 is supposed to have the front elements when looking at it as a queue
        //  s2 almost behaves like a queue
        if (!s2.isEmpty())
            return s2.pop();

        //  if s2 is empty then it means that the entire supposed queue is in the stack
        // transfer everything to s2
        while (!s1.isEmpty())
            s2.push(s1.pop());

        return s2.pop();
    }

    public int peek() {
        // since s2 behaves like a queue, it will always have the front element in its top
        return s2.isEmpty() ? front : s2.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
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
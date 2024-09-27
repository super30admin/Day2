//        Time Complexity: Push Operation : O(1)
//
//                            Pop Operation: O(N)
//        Space Complexity: O(N)
        //Did it successfully run on Leetcode: Yes
//
//Any Problems : No

        class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> S1;
    Stack<Integer> S2;
    public MyQueue() {
        S1 = new Stack<>();
        S2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        S1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!S1.isEmpty()) {
            S2.push(S1.pop());
        }
        int num = S2.pop();
        while (!S2.isEmpty()) {
            S1.push(S2.pop());
        }
        return num;
    }

    /** Get the front element. */
    public int peek() {
        while (!S1.isEmpty()) {
            S2.push(S1.pop());
        }
        int num = S2.peek();
        while (!S2.isEmpty()) {
            S1.push(S2.pop());
        }
        return num;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return S1.isEmpty();
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
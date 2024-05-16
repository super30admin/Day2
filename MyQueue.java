// Time Complexity : push() : O(1), pop() : O(1), peek() : O(1), empty() : O(1)
// Space Complexity : O(2N) => O(N) (As we are using 2 stacks)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Approach: Used 2 stacks in and out,
 * For push operation, push elements in "in" stack
 * For pop & peek operation, check if out stack is Empty, pop all the elements
 * from in stack and push to out stack
 * This will help in reversing the order in which elements are stored and can
 * pop & peek from out stack
 */
class MyQueue {

    Stack<Integer> in; // Used for push operation
    Stack<Integer> out; // Used for peek & pop opeartion

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        peek();
        return out.pop();
    }

    public int peek() {
        // Checks if out stack isEmpty(), if yes then pop elements from in stack &
        // pushes in out stack
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    public boolean empty() {
        // If both in and out stacks are empty it indicates the stack is empty
        return in.isEmpty() && out.isEmpty();
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
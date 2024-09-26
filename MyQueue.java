//Queue using Stack

// Time Complexity :  O(1) for all push ,pop and peek operations
// Space Complexity : O(1) as there is no auxiliary space needed
// Did this code successfully run on Leetcode :  Yes
// Any problem you faced while coding this : No

// CODE 

class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack();
        out = new Stack();
    }

    public void push(int x) {
        in.push(x); // pushing value in "in" stack
    }

    public int pop() {
        peek(); // calling peek() function to check if "out" stack is empty or not
        return out.pop(); // popping from "out" stack as deletion in queue is done from start
    }

    public int peek() {
        if (out.isEmpty()) { // if "out" stack if empty ,then we will transfer all the elements from "in"
                             // stack to "out" stack
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek(); // returning the element from the head of the queue
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty(); // if both the stacks are empty ,then queue is empty
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
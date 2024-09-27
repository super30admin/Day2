// Time Complexity    : O(1) for all operations
// Space Complexity   : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this    : No

class QueueUsingStacks {
    // in stack for pushing the incoming elements
    Stack<Integer> in;
    // to perform queue operations correctly in O(1) time
    Stack<Integer> out;

    /** Initialize your data structure here. */
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    // Check if outStack is empty, if yes, push all elements from inStack to outStack and pop the top of outStack
    public int pop() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    /** Get the front element. */
    // Again push all elements from inStack to outStack if outStack is empty and return the top element of the outStack
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
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

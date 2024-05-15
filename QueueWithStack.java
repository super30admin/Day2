// Time Complexity : Push - O(1), Pop - O(1) (amortized), Peek - O(1) (amortized), empty - O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// logic: push the element into the "in" stack when pop is called for the first time
// push all elements from "in" to "out" stack. Pop elements from "out" stack and push elements into "in" stack.
// Use "out" stack for peek() and check if "in" and "out" stacks are empty or not for the empty().

class QueueWithStack {

    Stack<Integer> in;
    Stack <Integer> out;

    public QueueWithStack() {
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
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }

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
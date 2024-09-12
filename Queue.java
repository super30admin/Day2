// Time Complexity : push operation is O(1) and pop average is O(1) and sometimes it goes upto O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : pop operation can be peek (optimized)

// Your code here along with comments explaining your approach

class MyQueue {
    private Stack<Integer> in;
    private Stack<Integer> out;

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
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}

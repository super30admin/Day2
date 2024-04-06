// Time Complexity : O(1) - Pop, Push and Find
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyQueue {

    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();
    private int front;

    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }

    /**
     * T - O(n)
     * @param x
     */
    public void push(int x) {
        in.push(x);
    }

    //O(1)
    public int pop() {
        // if out stack is empty
        if(out.isEmpty()) {
            // check if in stack is empty or not
            while(!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        // if out stack is not empty, pop it from out stack
        return out.pop();
    }

    //O(1)
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    //O(1)
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}

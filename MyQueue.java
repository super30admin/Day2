class MyQueue {

    /** Initialize your data structure here. */
    private Stack<Integer> in, out;
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    // Time Complexity: O(1)
    // Space Complexity: O(n)
    public void push(int x) {
        in.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    // Time Complexity: O(1) (Amortized)
    // Space Complexity: O(1)
    public int pop() {
        peek();
        return out.pop();
    }
    
    /** Get the front element. */
    // Time Complexity: O(1) (Amortized)
    // Space Complexity: O(1)
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty())
                out.push(in.pop());
        }
        return out.peek();
    }
    
    /** Returns whether the queue is empty. */
    // Time Complexity: O(1)
    // Space Complexity: O(1)
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
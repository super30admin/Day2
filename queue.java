// Time complexity
// Pop() - O(n) worst O(1) avg
// Peek() - O(n) worst O(1) avg
// Push() - O(1)

// Space Complexity
// O(n)

class MyQueue {
    
    private Stack<Integer> in;
    private Stack<Integer> out;

    public MyQueue() {
        in = new Stack();
        out = new Stack();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    private void copyInToOut() {
        if(out.isEmpty()) {
            while(!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        
    }
          
    public int pop() {
        copyInToOut();
        return out.pop();
    }
    
    public int peek() {
        copyInToOut();
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

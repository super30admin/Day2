// Time Complexity : Push O(N) and POP, PEEK, EMPTY O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyQueue {
    private Stack<Integer> st1;
    private Stack<Integer> st2;

    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
        
    }
    
    public void push(int x) {
        while (!st1.isEmpty())
        {
            st2.push(st1.pop());
        }
        st1.push(x);
        while (!st2.isEmpty())
        {
            st1.push(st2.pop());
        }
    }
    
    public int pop() {
        return !empty() ? st1.pop() : -1;
    }
    
    public int peek() {
        return st1.peek();
    }
    
    public boolean empty() {
        return st1.isEmpty();
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
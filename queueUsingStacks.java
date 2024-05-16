/*
Approach - Consider two stacks, using first stack for push and second stack for pop/peek operations
Time Complexity - worst case O(n) for pop, best case is O(1) - amortized. push is constant O(1)
Space Complexity - O(n) takes up n spaces of memory
Did this code successfully run on Leetcode : yes
*/ 

class MyQueue {
    Stack<Integer> sin;
    Stack<Integer> sout;

    public MyQueue() {
        sin = new Stack<>();
        sout = new Stack<>();
    }
    
    public void push(int x) {
        sin.push(x);
    }
    
    public int pop() {
        peek();
        return sout.pop();
    }
    
    public int peek() {
        if(sout.isEmpty())
            while(!sin.isEmpty()) {
                sout.push(sin.pop());
            }
        return sout.peek();
    }
    
    public boolean empty() {
        return (sin.isEmpty() && sout.isEmpty());
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
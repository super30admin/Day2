
//Time complexity -O(n)
//space complexity -O(n)

class MyQueue {
    private Stack<Integer> st1;
    private Stack<Integer> st2;
    private int front;
    /** Initialize your data structure here. */
    public MyQueue() {
        st1=new Stack<>();
        st2=new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        st1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        shift();
        return st2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        shift();
        return st2.peek();
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }
    public void shift() {
        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
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
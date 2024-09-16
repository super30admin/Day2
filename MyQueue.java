class MyQueue {
    Stack<Integer> push_stack;
    Stack<Integer> pop_stack;
    /** Initialize your data structure here. */
    public MyQueue() {
        push_stack = new Stack<Integer>();
        pop_stack = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!pop_stack.isEmpty()){
            push_stack.push(pop_stack.pop());
        }
        push_stack.add(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!push_stack.isEmpty()){
            pop_stack.push(push_stack.pop());
        }
        return pop_stack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        while(!push_stack.isEmpty()){
            pop_stack.push(push_stack.pop());
        }
        return pop_stack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return push_stack.isEmpty() && pop_stack.isEmpty();
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
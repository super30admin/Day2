class MyQueue {
    //Create 2 stacks
    //Push inside in stack
	// pop and peek inside out stack
    
    Stack<Integer> in;
    Stack<Integer> out;
       
    
    /** Initialize your data structure here. */
    public MyQueue() {
        in = new Stack<Integer>();
        out = new Stack<Integer>();
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x) ;   
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(out.isEmpty()){
            //keep pushing into out stack from in stack
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.pop();
    }
    
    /** Get the front element. */
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

/*Time Complexity*
O(1) is push and empty
O(n) is pop and peek

Space complexity
O(1) whatever given inside in stack is used in out stack.

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
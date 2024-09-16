class MyQueue {
    /** Initialize your data structure here. */
    Stack<Integer> in; // Stack for pushing in the elements
    Stack<Integer> out; //Stack for popping all the elements
    public MyQueue() {
        in = new Stack(); 
        out = new Stack();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x); 
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
         return out.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){    //Inversion of push stack to pop stack
                out.push(in.pop());
            }   
        }
         return out.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(in.isEmpty() && out.isEmpty()){
            return true;
        }
        return false;
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
}

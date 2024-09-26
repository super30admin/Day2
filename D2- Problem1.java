class MyQueue {
    // Initializing the two stacks : instack for storing the pushed elements and outstack for storing the elements in a queue manner whenever pop and peek occurs
    
    //  Amortized O(1) TC
    Stack<Integer> instack;
    Stack<Integer> outstack;

    /** Initialize your data structure here. */
    public MyQueue() {
        instack = new Stack<Integer>();
        outstack = new Stack<Integer>();
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        instack.push(x);
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // pushing all the elements from instack to outstack
        peek();
        
        return outstack.pop();
        
    }
    
    /** Get the front element. */
    public int peek() {
        // pushing all the elements from instack to outstack
        if(outstack.isEmpty())
        {
            while(!instack.isEmpty())
            {
                outstack.push(instack.pop());
            }
        }
        
        return outstack.peek();
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        // checking both instack and outstack are empty
        
        return instack.empty()&& outstack.empty();
        
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
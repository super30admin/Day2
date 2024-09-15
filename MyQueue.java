class MyQueue {
    Stack<Integer> mainStack = new Stack<Integer>();
    Stack<Integer> supportStack = new Stack<Integer>();
    int peek;
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        mainStack.push(x);
        //run time - O(1) - standard push into stack
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //run time - O(n) - when support stack is empty else drops doen to constant time
        if(!supportStack.isEmpty())
        {
            return supportStack.pop();
        }
        while(!mainStack.isEmpty())
        {
            supportStack.push(mainStack.pop());
        }
        return supportStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        //run time - O(n) - when support stack is empty else drops doen to constant time
        if(!supportStack.isEmpty())
        {
            return supportStack.peek();
        }
        while(!mainStack.isEmpty())
        {
            supportStack.push(mainStack.pop());
        }
        return supportStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(mainStack.isEmpty() && supportStack.isEmpty())
        {
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

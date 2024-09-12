class MyQueue {
    // two stacks one is a normal stack 
    // Second one stack2 is for deque
    Stack stack1 = new Stack();
    Stack stack2 = new Stack();

    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    // simple push stateemnt    
        stack1.push(x);
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
            
        }
        Object x = stack2.pop();
        
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        
        return (int)x;
    }
    
    /** Get the front element. */
    public int peek() {
        Iterator value = stack1.iterator();
        return (int)value.next();
        
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        
        if (stack1.isEmpty())
            return true;
        else
            return false;
    }
}
// TC- push- O(1), pop- O(2N)-to be precise, peek- O(N) since iterator is used, empty- O(1)
//SC- O(N) since all the values given are stored (used)
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

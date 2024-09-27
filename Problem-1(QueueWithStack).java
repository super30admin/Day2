class MyQueue {

    /** Initialize your data structure here. */
    
    /* Algorithm:
        1. We have 2 stacks, primary and seconday. While pushing we are directly pushing the elements to primary.
        2. For pop operation and peek operation, Check if secondary stack is empty. If we have secondary stack empty then we will first pop all the elements from primary stack and push it to secondary stack. We will always pop or peek from the secondary stack.
        3. For isEmpty operation, Check if both primary and secondary stack are empty. If yes return true else return false.
        
        Time complexity: Average time complexit O(1)
        Space complexity: O(n)
        
        Whether the code ran on leetcode? Yes
        
    */
    
    Stack<Integer> primary;
    Stack<Integer> secondary;
    
    public MyQueue() {
        primary = new Stack<>();
        secondary = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        primary.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(secondary.isEmpty()){
            while(!primary.isEmpty()){
                secondary.push(primary.pop());
            }
        }
       return secondary.pop();
        
    }
    
    /** Get the front element. */
    public int peek() {
        if(secondary.isEmpty()){
            while(!primary.isEmpty()){
                secondary.push(primary.pop());
            }
        }
       return secondary.peek();
        
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
         return primary.isEmpty() && secondary.isEmpty() ;
         
        
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
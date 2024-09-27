import java.util.Stack;

class MyQueue {

/// implementing queue  using stack where one stack is taken and front pointer is kept to remove elements from top.
// adding operation in queue is same as stack while poping the element it should be FIFO. so pointer act indicates first element on stack 
// and removes it while checking boundary conditions.

    Stack<Integer>  stack;
    int pointer =0;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack();
       
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
   
        stack.add(x);
       
}
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int i = 0;
        if(stack.isEmpty()){
            return 0;
        }else{
         i = stack.get(pointer);
         stack.remove(pointer);
        }
        return i;
        
    }
    
    /** Get the front element. */
    public int peek() {
        int i = stack.get(pointer) ;
            if(i == 0){
                return 0;
            }
       return i;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
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
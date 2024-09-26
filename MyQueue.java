//Time complexity: O(1)
//Space complexity: O(n)
import java.util.Stack;

class MyQueue {
    private Stack<Integer> input;
    private Stack<Integer> output;
    
    /** Initialize your data structure here. */
    public MyQueue() {
         input= new Stack<>();
         output= new Stack<>();
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x);
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return output.pop();
        
    }
    
    /** Get the front element. */
    public int peek() {
        if(output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }
        return output.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return input.isEmpty()&& output.isEmpty();
        
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
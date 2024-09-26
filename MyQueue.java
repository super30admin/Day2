// Time Complexity : O(1) for all operations because we only copy the elements if the pop stack is empty
// Space Complexity : O(n) since using additional stack
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyQueue {
    Stack<Integer> push_stack;
    Stack<Integer> pop_stack;

    public MyQueue() {
      push_stack = new Stack<Integer>();
      pop_stack = new Stack<Integer>();

        
    }
    
    public void push(int x) {
        //push to push stack
        push_stack.push(x);
  
        
    }
    
    public int pop() {
        //only if pop stack is empty then copy all the popped elements from push stack to the pop stack and pop the ellement from pop stack
        if(pop_stack.empty()){
            while(!push_stack.empty()){
                pop_stack.push(push_stack.pop());
            }
        }
        return pop_stack.pop();
    }
    
    public int peek() {
        //same as pop but just return the element instead of pop
        if(pop_stack.empty()){
                while(!push_stack.empty()){
                    pop_stack.push(push_stack.pop());
                }
            }
            
            return pop_stack.peek();
        
    }
    
    public boolean empty() {
        //if both stacks are empty then queue is empty
        return push_stack.empty() && pop_stack.empty();
        
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
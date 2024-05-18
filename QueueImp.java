//Time complexity - O(1)  - amortized O(1) for peek and empty as it may go to O(n)
//Space complexity - O(n)
//We create two stacks. Pushing the elements happens in a straighforward way. Whenever we need to peek() or pop(), we first check if the second stack
// is empty. If empty, copy elements from first stack and put it in the second stack so that we have access to the oldest element ( first element that we added)
// if second stack is not empty then simply peek and then pop. 
import java.util.*;
class MyQueue {
    
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        peek();
        return stack2.pop();
         
    }
    
    public int peek() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            
        
    }
    return stack2.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
        
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
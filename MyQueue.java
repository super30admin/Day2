//  Time Complexity : O(1) for push,empty and amortized O(1) for pop,peek
// Space Complexity : O(1)
//  Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No







import java.util.Stack;

class MyQueue {
    
    private Stack<Integer> stack1;
      private Stack<Integer> stack2;

    public MyQueue() {
        stack1 =new Stack<>();
       stack2 = new Stack<>();
        
    }
    
    public void push(int x) {
        stack1.push(x);
        
    }
    
    public int pop() {
    
        if (!stack2.isEmpty())
        {
            return stack2.pop();
        }
        else{
            while(!stack1.isEmpty())
            {
            int ele=stack1.pop();
                stack2.push(ele);
            }
            return stack2.pop();
            
        }
        
        
    }
    
    public int peek() {
        if (!stack2.isEmpty())
        {
            return stack2.peek();
        }
        else{
            while(!stack1.isEmpty())
            {
            int ele=stack1.pop();
                stack2.push(ele);
            }
            return stack2.peek();
            
        }
 
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
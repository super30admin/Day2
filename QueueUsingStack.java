// Time Complexity :pop(),peek()->O(n), empty(),push()-> O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class MyQueue {
    
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() 
    {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        if(stack2.isEmpty())
            while(!stack1.isEmpty())
            {
                stack2.push(stack1.pop());
            }
        return stack2.pop();
    }
    
    public int peek() {
        if(stack2.isEmpty())
            while(!stack1.isEmpty())
            {
                stack2.push(stack1.pop());
            }
        return stack2.peek();
        
    }
    
    public boolean empty() {
        if(stack2.isEmpty() && stack1.isEmpty()) return true;
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

 // Time Complexity :O(n) 
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public MyQueue() {
        stack1=new Stack<Integer>();
        stack2=new Stack<Integer>();
    }
    
    public void push(int x) {
        if(empty())
            stack1.push(x);
        else{
            while(!empty()){
                stack2.push(stack1.pop());
            }
            stack1.push(x);
            while(!stack2.isEmpty())
                stack1.push(stack2.pop());
        }
        
    }
    
    public int pop() {
        return stack1.pop();
        
    }
    
    public int peek() {
          return stack1.peek();
             
    }
    
    public boolean empty() {
        return stack1.isEmpty();
        
    }
}
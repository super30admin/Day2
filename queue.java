// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach

//We will be making use of 2 stacks in this approach 
//Until Peek or Pop comes in, we only push the elements into the “IN” stack. As soon as we encounter Peek or Pop we transfer from the “IN” stack to the “OUT” stack. 
//And now if OUT stack becomes empty then we will again transfer from IN to OUT stack.
class MyQueue {
    
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        
        in = new Stack<>();
        out = new Stack<>();
        
    }
    
    public void push(int x) {
        
        in.push(x);
        
    }
    
    public int pop() {
        
        peek();
        
        return out.pop();
    }
    
    public int peek() {
        
        if(out.isEmpty())
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        
        return out.peek();
        
    }
    
    public boolean empty() {
        
        return out.isEmpty() && in.isEmpty();
  
    }   
    
}

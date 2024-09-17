//Time Complexity: O(1) Amortized
//Space Complexity: O(n)
// Code successfully run on LeetCode.
import java.util.Stack;

class MyQueue {
	
	Stack<Integer> in;
	Stack<Integer> out;
    int front;

    public MyQueue() {
    	in = new Stack<>();
    	out = new Stack<>();
    }
    
    public void push(int x) {
        if(in.isEmpty())
            front = x;
    	in.push(x);
    }
    
    public int pop() {
        
    	if(out.isEmpty())
    	{
    		while(!in.isEmpty())
    		{
    			out.push(in.pop());
    		}	
    	}
    	return out.pop();
    }
    
    public int peek() {
    	if(out.isEmpty())
            return front;
        
    	return out.peek();
    }
    
    public boolean empty() {
    	return in.isEmpty() && out.isEmpty(); 
    }
}

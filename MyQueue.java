import java.util.Stack;

//Time Complexity : o(n);
//Space Complexity : not sure using 2 stacks 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : not able to understand the space required, where i can learn time and space complexity?

public class MyQueue {
	
	 Stack<Integer> in = new Stack<>();
	 Stack<Integer> out = new Stack<>();

	    public MyQueue() {
	        this.in = in;
	        this.out = out;
	    }
	    
	    public void push(int x) {
	        in.push(x);
	        
	    }
	    
	    public int pop() {
	        if(!out.isEmpty()) return out.pop();
	        else{
	            while(!in.isEmpty()){
	                out.push(in.pop());
	            }
	        }
	        return out.pop();
	        
	    }
	    
	    public int peek() {
	        if(!out.isEmpty()) return out.peek();
	        else{
	            while(!in.isEmpty()){
	                out.push(in.pop());
	            }
	        }
	        return out.peek();
	    }
	    
	    public boolean empty() {
	        return in.isEmpty() && out.isEmpty();
	    }
	

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		
		queue.push(1);
		queue.push(10);
		queue.push(20);
		System.out.println(queue.peek());
		queue.pop();
		System.out.println(queue.empty());
		System.out.println(queue.peek());		

	}

}

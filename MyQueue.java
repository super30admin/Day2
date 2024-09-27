/*import java.util.Stack;

public class MyQueue {

	private Stack<Integer> s1;
	private Stack<Integer> s2;
	private int front;
	  /** Initialize your data structure here. */
 /*   public MyQueue() {
        s1= new Stack<Integer>();
        s2= new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
//Complexity Time: O(n) space :O(n)
  /*  public void push(int x) {
    	 if (s1.empty())
    	        front = x;
    	    while (!s1.isEmpty())
    	        s2.push(s1.pop());
    	    s2.push(x);
    	    while (!s2.isEmpty())
    	        s1.push(s2.pop());
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
//Complexity Time: O(1) space :O(1)
  /*  public int pop() {
    	int ele= s1.pop();
    	    if (!s1.empty())
    	        front = s1.peek();
        return ele;
    }
    
    /** Get the front element. */
//Complexity Time: O(1) space :O(1)
   /* public int peek() {
      
        
        return front;
    }
    
    /** Returns whether the queue is empty. */
//Complexity Time: O(1) space :O(1)
  /*  public boolean empty() {
        return s1.isEmpty();
    }
    
    public static void main(String args[]) {
    	
    	MyQueue obj = new MyQueue();
    	obj.push(1);
    	obj.push(2);
    	//obj.push(3);
    	
    	System.out.println("peek : " +obj.peek());
    	System.out.println("pop : " +obj.pop());
    	System.out.println(obj.peek());
    }
}

*/

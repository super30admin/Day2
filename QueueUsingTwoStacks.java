import java.io.*;
import java.util.*;

class QueueUsingTwoStacks {

	    private Stack<Integer> s1,s2;
	    
	    /** Initialize your data structure here. */
	    public QueueUsingTwoStacks() {
	        s1 = new Stack<>();
	        s2 = new Stack<>();
	    }
	    
	    /** Push element x to the back of queue. */
	    public void push(int x) {
	        s1.push(x);
	    }
	    
	    /** Removes the element from in front of queue and returns that element. */
	    public int pop() {
	        if(s2.isEmpty()){
	            while(!s1.isEmpty())
	                s2.push(s1.pop());
	        }
	        return s2.pop();
	    }
	    
	    /** Get the front element. */
	    public int peek() {
	        if(!s2.isEmpty())
	            return s2.peek();
	        else{
	            while(!s1.isEmpty())
	                s2.push(s1.pop());
	        }
	        return s2.peek();
	    }
	    
	    /** Returns whether the queue is empty. */
	    public boolean empty() {
	        return s1.isEmpty() && s2.isEmpty();
	    }
	    
	    public static void main(String args[]) 
	    { 
	        QueueUsingTwoStacks ob = new QueueUsingTwoStacks(); 
	        ob.push(34);
	        ob.push(21);
	        ob.push(56);
	        ob.push(131);
	        System.out.println("Peek element is: "+ob.peek()); 
	        System.out.println("Popped element is: "+ob.pop());
	        System.out.println("The new Peek element is: "+ob.peek());
	    } 
}

//Time complexity: O(1) for push and isempty, O(1) for pop but in worst case it is O(N), same complexity as pop for peek
// Space complexity: O(N) for push inorder to store new elements, O(1) for ppop, peek and isempty
import java.util.Stack;

public class QueueUsingStack {

	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();
	/*
	 * Push element x to the back of queue.
	 */
	public void push(int x) {
		//Making push operation costly by making push operaion in O(n) time
		//whenever new element comes insert all elements from stack1 to stack2 insert new element in stack1 and 
		//then insert all elements from stack2 to stack1 
		//so wheneve you pop element from the stack that will be the last element inserted
		while(!stack1.isEmpty())
			stack2.push(stack1.pop());
		
		stack1.push(x);
		
		while(!stack2.isEmpty())
			stack1.push(stack2.pop());
	}
	/*
	 * Removes the element from in front of queue.
	 */
	public int pop() {
		 if(isEmpty())
			return -1;
		 return stack1.pop();
	}
	/*
	 * Get the front element.
	 */
	public int peek() {
		if(isEmpty())
			return -1;
		return stack1.peek();
	}
	/*
	 * Return whether the queue is empty.
	 */
	public boolean isEmpty() {
		return stack1.isEmpty();
	}
    public static void main(String args[]) 
    { 
    	QueueUsingStack queue = new QueueUsingStack();
    	queue.push(1);
    	queue.push(2);  
    	System.out.println(queue.peek()); // returns false
    	System.out.println(queue.pop()); // returns false
    	System.out.println(queue.isEmpty()); // returns false
    } 
}
//Time Complexity :
//Space Complexity :
//Did this code successfully run on Leetcode :
//Any problem you faced while coding this :
//Your code here along with comments explaining your approach
/*
 * Queue hold First in First Out policy. Element inserted first should be removed first
 * when we implement the queue using stack we need to 
 */

import java.util.Stack;

public class Queue {

	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();
	
	public void push(int data) {
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		stack1.push(data);
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
	}
	
	public int pop() {
		if(stack1.isEmpty()) {
			return 0;
		}else {
			return stack1.pop();
		}
	}
	
	public boolean isEmpty() {
		if(stack1.size() == 0) {
			return true;
		}
		return false;
	}
	
	public int peek() {
        if(stack1.size() == 0) {
			return 0;
		}
        int x = stack1.pop();
        stack1.push(x);
        return x;
    }

	public static void main(String[] args) {
		Queue myQueue = new Queue();
		myQueue.push(10);
		myQueue.push(20);
		System.out.println(myQueue.pop());
	}
}
//Time Complexity : push - O(n), pop,peek - O(1)
//Space Complexity : push - O(n), pop,peek - O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
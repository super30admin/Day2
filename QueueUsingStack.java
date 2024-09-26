// Time Complexity : push  -> O(N) , pop --> O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : No

import java.util.Stack;

public class QueueUsingStack{
	
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
	
	public QueueUsingStack(){
		
	}
	
	public void push(int x) {
		
		while(!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		
		s1.push(x);
		
		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}
	
	public int pop() {
		return s1.pop();
	}
	
	public int peek() {
		return s1.peek();
	}

    public boolean empty(){
        return s1.isEmpty() && s2.isEmpty();
    }
	
		
	public static void main(String[] args) {
		QueueUsingStack queue = new QueueUsingStack();
		queue.push(5);
		queue.push(2);
		System.out.println(queue.peek());		
		System.out.println(queue.pop());
        System.out.println(queue.empty());
	}
}

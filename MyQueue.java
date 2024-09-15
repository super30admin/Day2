
import java.util.*;
//Time Complexity: push :O(1), peek: O(N), pop: O(N)
//Space Compexity: O(1)

public class MyQueue {
Stack<Integer> s1;
Stack<Integer> s2;

public MyQueue(){
	s1 = new Stack<>();
	s2 = new Stack<>();
}
public void push(int x) {
	s1.push(x);					//push will put everything is s1 and not in s2.
}
public int pop() {
	peek();
	return s2.pop(); 
}
public int peek() {			//when peek is call, checking is s2 stack is empty and transferring everything into it
	if(s2.isEmpty()) {
		while(!s1.isEmpty()) {
			s2.push(s1.pop());
		}
	}return s2.peek();			//s2 will return element is FIFO manner
}
public boolean empty() {
	return s1.isEmpty() && s2.isEmpty();
}
public static void main(String[] args) {
	int x = 0;
	MyQueue sp = new MyQueue();
	sp.push(5);
	sp.push(4);
	sp.push(8);
	System.out.println(sp.peek());
}
}

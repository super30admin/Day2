import java.util.*;
class MyQueue {
    
    Stack<Integer> one, two;
    int front;
    /** Initialize your data structure here. */
    public MyQueue() {
        one = new Stack<Integer>();
        two = new Stack<Integer>();
        front = 0;
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(one.isEmpty()){
            front = x;
        }
        one.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(two.isEmpty()){
            while(!one.isEmpty()){
                two.push(one.pop());
            }
        }
        return two.pop();
        
    }
    
    /** Get the front element. */
    public int peek() {
        if(!two.isEmpty()){
            return two.peek();
        }
        return front;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return one.isEmpty() && two.isEmpty();
    }
}

public class QueueUsingStack {

	public static void main(String[] args) {
		
		 //Your MyQueue object will be instantiated and called as such:
		 MyQueue obj = new MyQueue();
		 obj.push(1);
		 int param_2 = obj.pop();
		 int param_3 = obj.peek();
		 boolean param_4 = obj.empty();
	}

}

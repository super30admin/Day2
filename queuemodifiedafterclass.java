/*
Time Complexity
push O(1)
pop O(2n)->O(n)
peek O(n)

Space Complexity
O(n) for push and peek
O(n) for pop
*/
import java.util.Stack;
class MyQueue {
    Stack<Integer> a;
    Stack<Integer> b;
    public MyQueue() {
        a=new Stack<Integer>();
        b=new Stack<Integer>();
    }
    
    public void push(int x) {
        a.push(x);
    }
    
    public int pop() {
        if(b.isEmpty()&&!a.isEmpty()){
		while(!a.isEmpty()){
		b.push(a.pop());		
		}
        }
		return b.pop();
	}
    
    public int peek() {
	        if(b.isEmpty()&&!a.isEmpty()){
		while(!a.isEmpty()){
		b.push(a.pop());		
		}
        }
        return b.peek();
    }
    
    public boolean empty() {
    if(a.empty()&&b.empty()){
		return true;
    }
	return false;
	}
	 /*   public boolean empty() {
    if(a.empty()&&b.empty()){
		return true;
    }
	return false;
    }
	Should be faster than popping, pushing and then checking. But in leet code this was running slow for some reason.
	*/
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
/*
Time Complexity
push O(1)
pop O(2n)->O(n)
peek O(1)

Space Complexity
O(1) for push and peek
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
        int returnv;
    	while(!a.isEmpty()){
            b.push(a.pop());
        }
        returnv=b.pop();
        while(!b.isEmpty()){
            a.push(b.pop());
        }
        return returnv;
        }
    
    public int peek() {
    	if(!a.isEmpty()) {
    		return  a.elementAt(0);
    	
    	}
    	return -1;
    }
    
    public boolean empty() {
        return a.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
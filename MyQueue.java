import java.util.Stack;

class MyQueue {
    private Stack<Integer> stk;
    
    public MyQueue() {
        stk= new Stack<>();
    }
    
    public void push(int x) {
    	Stack<Integer> st= new Stack<>();
        if(!stk.isEmpty()){
            st.push(stk.pop());
        }
        st.push(x);
        
        while(!st.isEmpty()) {
        	stk.push(st.pop());
        }
    }
    
    public int pop() {
        return stk.pop();
    }
    
    public int peek() {
        return stk.peek();
    }
    
    public boolean empty() {
        return stk.isEmpty();
    }
    
	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.push(1);
		queue.push(2);
		queue.peek(); // returns 1
		queue.pop(); // returns 1
		queue.empty(); // returns false
	}
}

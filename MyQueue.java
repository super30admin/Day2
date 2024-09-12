import java.util.Stack;

class MyQueue {

    private Stack<Integer> st;
    private int firstvalue;

    public MyQueue() {
        this.st = new Stack<>();
    }
    
    public void push(int x) {
        if(this.st.isEmpty()){
            this.firstvalue = x;
        }
        this.st.push(x);
    }
    
    public int pop() {
        Stack<Integer> st2 = new Stack<>();
        while(!this.st.isEmpty()){
            st2.push(this.s1.pop());
        }
        int first = st2.pop();
        this.firstvalue = s2.peek();
        while(!st2.isEmpty()){
            this.st1.push(st2.pop());
        }
        return first;
    }
    
    public int peek() {
        return this.firstvalue;
    }
    
    public boolean empty() {
        if(this.st.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}
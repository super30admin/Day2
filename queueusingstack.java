class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;
    int front,top;
    public MyQueue() {
        st1=new Stack<Integer>();    
        st2=new Stack<Integer>();
    
    }
    
    public void push(int x) {
        if(st1.isEmpty()) front=x;
        st1.push(x);
    }
    
    public int pop() {
        if(st2.isEmpty()){
           while(!st1.isEmpty()) st2.push(st1.pop());
        }
        int del=st2.pop();
         if(!st2.isEmpty())top=st2.peek();
        return del;
    }
    
    public int peek() {
        if(st2.isEmpty())return front;
        return top;
    }
    
    public boolean empty() {
        if(st1.isEmpty()&&st2.isEmpty())return true;
        return false;
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

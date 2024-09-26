class MyQueue {
    Stack<Integer>st1;
    Stack<Integer>st2;
    public MyQueue() {
        this.st1=new Stack<>();
        this.st2=new Stack<>();
    }
    
    public void push(int x) {
        while(st1.empty()==false){
            st2.push(st1.peek());
            st1.pop();
        }
        st1.push(x);
        while(st2.empty()==false){
            st1.push(st2.pop());
        }
    }
    
    public int pop() {
        return st1.pop();
    }
    
    public int peek() {
       return st1.peek();
    }
    
    public boolean empty() {
        
        if(st1.empty()){
             return true;
        }
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
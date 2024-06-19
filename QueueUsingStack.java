class MyQueue {
    Stack<Integer> s1 =new Stack<>();
    Stack<Integer> s2 =new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if(s2.empty()){
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
        
        return s2.pop();
    }
    
    public int peek() {
        if(!s2.empty()){
            return s2.peek();
        }else{
            while(!s1.empty()){
                s2.push(s1.pop());
            }
            return s2.peek();
        }
    }
    
    public boolean empty() {
        if(s1.empty() && s2.empty()) return true;
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
class MyQueue {
    private Stack<Integer> st1;
    private Stack<Integer> st2;

    public MyQueue() {
        st1 = new Stack();
        st2 = new Stack();
        
    }
    
    public void push(int x) {
        if(st1.empty() && st2.empty()){
            st1.push(x);
        }else{
            do{ if(!st2.empty()){
                st1.push(st2.pop());}
            }while(!st2.empty());
            st1.push(x);
                
        }
        
        
    }
    
    public int pop() {
        int popElement;
        while(!st1.empty()){
            st2.push(st1.pop());
        }
        
        popElement = st2.pop();
        while(!st2.empty()){
            st1.push(st2.pop());
        }
        return popElement;
        
    }
    
    public int peek() {
        while(!st1.empty()){
            st2.push(st1.pop());
        }
        int peekElement = st2.peek();
         while(!st2.empty()){
            st1.push(st2.pop());
        }
        
        
        return peekElement;
        
        
    }
    
    public boolean empty() {
        if(st1.empty() && st2.empty())
            return true;
        else
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

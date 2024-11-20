class MyQueue {
    
    Stack<Integer> stack1; 
    Stack<Integer> stack2;

    public MyQueue() {
        stack1=new Stack<Integer>();
        stack2=new Stack<Integer>();
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        while(!stack1.isEmpty()){
            int x = stack1.pop();
            stack2.push(x);
        }
        
        int temp = stack2.pop();
         while(!stack2.isEmpty()){
            int y =  stack2.pop();
            stack1.push(y);
        }
        return temp;
    }
    
    public int peek() {
         while(!stack1.isEmpty()){
            int x = stack1.pop();
            stack2.push(x);
        }
        
        int temp = stack2.peek();
         while(!stack2.isEmpty()){
            int y =  stack2.pop();
            stack1.push(y);
        }
        return temp;
    }
    
    public boolean empty() {
        if(stack1.isEmpty()) {
            return true;
        } else{
            return false;
        }
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
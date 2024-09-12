class MyQueue {
    Stack <Integer> inStack; 
    Stack <Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        peek();
        return outStack.pop();
    }
    
    public int peek() {
       if(outStack.isEmpty()){
           while(!inStack.isEmpty()){
               outStack.push(inStack.pop());
           }
       }
        return outStack.peek();
    }
    
    public boolean empty() {
         return inStack.isEmpty() && outStack.isEmpty();
        
    }
}
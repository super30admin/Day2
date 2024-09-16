class queueUsingStacks{
    Stack<Integer> IN;
    Stack<Integer> OUT;

    public queueUsingStacks() {
        this.IN = new Stack<>();
        this.OUT = new Stack<>();
        
    }
    
    public void push(int x) {
        IN.push(x);
    }
    
    public int pop() {
        peek();
        return OUT.pop();
        
    }
    
    public int peek() {
        if (OUT.isEmpty()){
            while (!IN.isEmpty()){
                OUT.push(IN.pop());
                }
        }
        return OUT.peek();
    }
    
    public boolean empty() {
        return IN.isEmpty() && OUT.isEmpty();
    }

}
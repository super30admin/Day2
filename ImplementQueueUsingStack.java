class ImplementQueueUsingStack {

    Stack<Integer> in;
    Stack<Integer> out;
    
    public ImplementQueueUsingStack() {
        in = new Stack();
        out = new Stack();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        PopulateOutStack();
        return out.pop();
    }
    
    public int peek() {
        PopulateOutStack();
        return out.peek();
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
    
    private void PopulateOutStack()
    {
        if(out.isEmpty())
        {
            while(!in.isEmpty())
            {
                out.push(in.pop());
            }
        }
    }
}

/**
 * Your ImplementQueueUsingStack object will be instantiated and called as such:
 * ImplementQueueUsingStack obj = new ImplementQueueUsingStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
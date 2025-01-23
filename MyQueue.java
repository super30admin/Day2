class MyQueue {
private Stack<Integer> inst;
private Stack<Integer> outst;
    public MyQueue() {
         inst = new Stack<>();
         outst = new Stack<>();
    }
    
    public void push(int x) {
        inst.push(x);
    }
    
    public int pop() {
        if(outst.isEmpty())
        {
            while(!inst.isEmpty())
            outst.push(inst.pop());
        }
        return outst.pop();
    }
    
    public int peek() {
        if(outst.isEmpty())
        {
            while(!inst.isEmpty())
            outst.push(inst.pop());
        }
        return outst.peek();
    }
    
    public boolean empty() {
        if(inst.isEmpty() && outst.isEmpty())
        return true;
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
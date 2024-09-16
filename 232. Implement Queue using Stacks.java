class MyQueue {
private Stack<Integer> in;
private Stack<Integer> out;    
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    public void transfer(){
        while(!in.isEmpty()){
            out.push(in.pop());
        }
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        if(out.isEmpty()){
            transfer();
        }
        return out.pop();
    }
    
    public int peek() {
        if(out.isEmpty()) {
            transfer();
        }
        return out.peek();
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
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
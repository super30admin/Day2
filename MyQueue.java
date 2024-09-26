class MyQueue {
    private Stack<int> in;
    private Stack<int> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    private void transferIfRequired(){
        if(out.isEmpty()){
            while(!in.isEmpty())
            {
                out.push(in.pop());
            }
        }
    }

    public int pop() {
        transferIfRequired();
        return out.pop();
    }

    public int peek() {
        transferIfRequired();
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }


}
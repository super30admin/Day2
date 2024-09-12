//Time Complexity
//push time O(1),space O(1)
//pop time amortized O(1)
//peek time amortized O(1)
//empty time O(1)

class MyQueue {

    Stack<Integer> in;
    Stack<Integer> out;
    public MyQueue() {
        in= new Stack<>();
        out= new Stack<>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        if(out.empty())
            while(!in.empty())
                out.push(in.pop());
        return out.pop();
    }
    
    public int peek() {
        if(out.empty())
            while(!in.empty())
                out.push(in.pop());
        
        return out.peek();
    }
    
    public boolean empty() {
        if(in.empty() && out.empty())
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

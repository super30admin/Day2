public class Implentqueue {
    


    Stack<Integer> in;
    Stack<Integer> out;
    public MyQueue() {
        this.in  = new Stack();
        this.out = new Stack();
    }
    
    
    public void push(int x) {
        in.push(x);

    }
    
    public int pop() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.pop();
    }
    
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
        
    }
    
    public boolean empty() {
        boolean e = in.isEmpty() && out.isEmpty();

        return e;
    }
}


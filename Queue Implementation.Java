Queue Implementation
class MyQueue {
    Stack<Integer> in=new Stack<Integer>();
        
    Stack<Integer> out=new Stack<Integer>();
    public MyQueue() {
        
         
        
    }
    
    public void push(int x) {
        in.add(x);
        
    }
    
    public int pop() {
        if(in.empty()&& out.empty()){
            return -1;
        }
       
        while(!in.empty()){
            out.push(in.pop());
            
        }
       int c= out.pop();
       while(!out.empty()){
            in.push(out.pop());
            
        }
        return c;
         
    }
    
    public int peek() {
         while(!in.empty()){
            out.push(in.pop());
            
        }
       int d=out.peek();
        while(!out.empty()){
            in.push(out.pop());
            
        }
        return d;
    }
    
    public boolean empty() {
       if( in.empty()&& out.empty()){
           return true;
       }
        return false;
    }
}

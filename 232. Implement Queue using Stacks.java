import java.util.Stack;
class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
        
    }
    
    public void push(int x) {
        in.push(x);
        
    }
    
    public int pop() {
        peek();
        return out.pop();
        
    }
    
    public int peek() {
        if(out.isEmpty()) {
            while(!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
        
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
        
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }

}
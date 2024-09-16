import java.util.Stack;

class MyQueue {
    Stack<Integer> main_stack ;
    Stack<Integer> secondary_stack;

    public MyQueue() {
        main_stack = new Stack<>();
        secondary_stack = new Stack<>();
        
    }
    
    public void push(int x) {
        main_stack.push(x);
    }
    
    public int pop() {
        if(secondary_stack.isEmpty()){
            while(!main_stack.isEmpty()){
            secondary_stack.push(main_stack.pop());}
        }
        return secondary_stack.pop();
    }
    
    public int peek() {
        if(secondary_stack.isEmpty()){
            while(!main_stack.isEmpty()){
            secondary_stack.push(main_stack.pop());}
        }
        return secondary_stack.peek();
        
    }
    
    public boolean empty() {
        if(main_stack.isEmpty()&&secondary_stack.isEmpty()){
            return true;
        }
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
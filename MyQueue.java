import java.util.Stack;

class MyQueue {
    
    Stack <Integer>s1;
    Stack <Integer>s2;
    public MyQueue() {
        s1=new Stack();
        s2=new Stack();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        // pour all elements into Stack 2
        
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int temp=s2.pop();
        
        // pouring into stack 1
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return temp;
    }
    
    public int peek() {
        // pour all elements into Stack 2
        
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int temp=s2.peek();
        
        // pouring into stack 1
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return temp;
    }
    
    public boolean empty() {
        return s1.isEmpty();
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
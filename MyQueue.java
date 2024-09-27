//time complexity: push and pop O(1)
//space complexity: O(n) if I use two stacks 
import java.util.Stack;

class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    public MyQueue() {
        s1=new Stack<>();
       s2= new Stack<>();
        
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        peek();
        return s2.pop();
            
        
    }
    
    public int peek() {
        if(s2.isEmpty())
        {
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
        
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
        
    }
    public static void main(String args[]) 
    { 
        MyQueue mq = new MyQueue();  
        mq.push(11);
        mq.push(13);
        mq.pop();
        mq.peek();
        mq.push(12);
        mq.push(10);
        int val1 = mq.peek();
        int val2 = mq.pop();
        System.out.println(val1);
        System.out.println(val2);
    } 
}

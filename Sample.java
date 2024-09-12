import java.util.*;
class MyQueue {
     Stack<Integer> st1 = new Stack<>();
     Stack<Integer> st2 = new Stack<>();

    public MyQueue() {
        
    
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        st1.push(x);   
        
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(st2.empty()){
            while(!st1.empty())
               st2.push(st1.pop());
        
        }
         return st2.pop();
        
    }
    
    /** Get the front element. */
    public int peek() {
        if(!st2.empty())
        {
            return st2.peek();
        }
        else
        {
            while(!st1.empty())
            {
                st2.push(st1.pop());
            }
            return st2.peek();
        }
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(st1.empty() && st2.empty())
           return true;
         else 
             return false;
        
    }
    public static void main(String args[])
    {
        MyQueue obj = new MyQueue();
        obj.push(3);
        obj.push(4);
        obj.push(5);
        int c=obj. pop();
        int e=obj.pop();
        int d= obj.peek();
        boolean p = obj.empty();
        System.out.println(c +" " +e+" " +d +" "+ p);
    }
}


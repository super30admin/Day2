import java.lang.*;
class MyQueue {
     Stack<Integer> queue = new Stack();
     Stack<Integer> s2 = new Stack();  
        int front=-1; //first element of the queue
        

    /** Initialize your data structure here. */
    
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        
        if(queue.empty())
        {
           front =  x;
           
            queue.push(x);
            }
        else
            
        {while(! queue.isEmpty())
         
            {s2.push(queue.pop());}
        s2.push(x);
        while(!s2.isEmpty())
        {queue.push(s2.pop());}
    }}
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(front ==-1) //empty queue
        { return front;}
    else
            
        {int x =queue.pop();
         
        if(!queue.empty())
        {   front=queue.peek();
        }
         else 
         { front =-1;}
        
       return x;}
        
    }
    
    /** Get the front element. */
    public int peek() {
        return front;
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(front==-1)
        return true;
        else 
            return false;
    }
}
//time complexity is o(1)
//space complexity is o(n)
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
import java.util.Stack;

//time complexity: push:O(1) pop and peep:O(n)
//space complexity: O(n)
class MyQueue {

    Stack<Integer> enq;
    Stack<Integer> deenq;

    /** Initialize your data structure here. */
    public MyQueue() {
        enq=new Stack<>();
        deenq=new Stack<>();
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
       
        enq.push(x);

       
    
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
      if(deenq.isEmpty()){
        while(!enq.isEmpty())
        {
            deenq.push(enq.pop());
        }
      }
        return deenq.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(deenq.isEmpty())
        {
             while(!enq.isEmpty())
             {
                 deenq.push(enq.pop());
             }
            
        }
       
        return deenq.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
       if(enq.isEmpty()&&deenq.isEmpty())
       {
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

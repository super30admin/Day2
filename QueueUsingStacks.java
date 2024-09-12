//Time Complexity: amortized O(1)
//Space Complexity: O(1)
//Problem 232
class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> first;
    Stack<Integer> sec;
    public MyQueue() {
       first=new Stack<Integer>();
        sec=new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        first.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(sec.isEmpty())
        {
            while(!first.isEmpty())
            {
                sec.push(first.pop());
            }
            return sec.pop();
        }
        
       return sec.pop();
        
    }
    
    /** Get the front element. */
    public int peek() {
          if(sec.isEmpty())
        {
            while(!first.isEmpty())
            {
                sec.push(first.pop());
            }
            return sec.peek();
        }
        
       return sec.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return first.isEmpty() && sec.isEmpty();
    }
}
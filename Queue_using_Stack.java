class MyQueue {
    
    Stack q1;  
    Stack q2;
    int p; //to store the peek of queue
    

    /** Initialize your data structure here. */
    public MyQueue() {
        q1 = new Stack<Integer>();
        q2 = new Stack<Integer>();        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(q1.empty())
        {
            p = x;
        }
        q1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(q1.empty()!=true)
        {
            q2.push(q1.pop());
        }
        int re = (int)q2.pop();
        if(q2.empty()!=true)
        {
            p =(int) q2.peek();
        }
         while(q2.empty()!=true)
        {
            q1.push(q2.pop());
        }
        return re;
        
    }
    
    /** Get the front element. */
    public int peek() {
        return p;
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(q1.empty() && q2.empty())
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

 //runtime analysis -  it takes O(1) for peek(), push() and isEmpty()
 //                 -  it take O(n) for pop() because for pop i have to transfer all the elements from one stack to another and then 
 //                    back to the same stack so it take 2n which is O(n).
                    

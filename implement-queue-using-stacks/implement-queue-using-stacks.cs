public class MyQueue {
   public Stack instack = new Stack();
    public Stack outstack = new Stack();
​
    /** Initialize your data structure here. */
    public MyQueue() {
      
        
    }
    
    /** Push element x to the back of queue. */
    public void Push(int x) {
        instack.Push(x);
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int Pop() {
        Peek();
        return (int)outstack.Pop();
        
    }
    
    /** Get the front element. */
    public int Peek() {
        if(outstack.Count==0)
        {
            while(instack.Count!=0)
            {
                outstack.Push(instack.Pop());
            }
        }
        return (int)outstack.Peek();
        
    }
    
    /** Returns whether the queue is empty. */
    public bool Empty() {
        return (instack.Count==0 && outstack.Count==0);
        
    }
}
​
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.Push(x);
 * int param_2 = obj.Pop();
 * int param_3 = obj.Peek();
 * bool param_4 = obj.Empty();
 */

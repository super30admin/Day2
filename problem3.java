// Time Complexity : o(n) in pop and peek
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : initally faces null stack exemption.


// Your code here along with comments explaining your approach when pushed in on stack and popped from it and again pushing gives reverse order of normal stack which is queue

 Stack<Integer> a1=new Stack<>();
     Stack<Integer> a2=new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {
       
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        a1.push(x);
        
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(a2.isEmpty()){
         while(!a1.isEmpty()){
            a2.push(a1.pop());
         }
        }
        
    return a2.pop();}
    
    /** Get the front element. */
    public int peek() {
          if(a2.isEmpty()){
            while(!a1.isEmpty()){
                a2.push(a1.pop());
            }
        }
        int i=a2.pop();
        a2.push(i);
        return i;
    }
        
        

    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(a1.isEmpty() && a2.isEmpty()){
            return true;
            
        }
        
   return false; }
}
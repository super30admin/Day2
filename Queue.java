// Time Complexity :O(1) usually for all the operation but when values need to be tansfered to another stack it will be  O(n) in case of pop
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I did not faced any problem in this.
class Queue {

    /** Initialize your data structure here. */
    Stack<Integer> s1; 
    Stack<Integer> s2;
    int peek;
    public MyQueue() {
        s1=  new Stack<>();
        s2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
         if(s1.isEmpty())
             peek = x;
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
       if(s2.isEmpty())
       {
           while(!s1.isEmpty())
           {
               s2.push(s1.pop());
           }
       }
        return s2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return s2.isEmpty()?peek:s2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

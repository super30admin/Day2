package Default;
//Time Complexity : O(1)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
class MyQueue {

    /** Initialize your data structure here. */
      Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        
        s1.add(x);
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        
        if(s2.isEmpty()){
        
        while(!s1.isEmpty()){
            
            s2.add(s1.pop());
        }
            return s2.pop();
    }     
        
       else return s2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        
        if(s2.isEmpty()){
        
        while(!s1.isEmpty()){
            
            s2.add(s1.pop());
        }
            return s2.peek();
    }     
        
       else return s2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        
        if(s1.isEmpty() && s2.isEmpty()){
            
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
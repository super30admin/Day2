// Time Complexity : push = O(1), peek = O(1), empty = O(1), pop = Amortized O(1), worst case O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class MyQueue {
    
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    private int front;

    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        
        if(s1.isEmpty()){
            front = x;
        }
        
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        
       return s2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        
        if(!s2.isEmpty()){
             return s2.peek();
        }
        
        return front;
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
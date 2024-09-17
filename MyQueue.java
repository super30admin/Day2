// Time Complexity :O(n) for the push() method
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None


// Your code here along with comments explaining your approach

class MyQueue {
    
    Stack<Integer> st = new Stack();
    Stack<Integer> qu = new Stack();
    

    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(qu.isEmpty()){
            qu.add(x);
        }
        else{
            while(!qu.isEmpty()){
                st.add(qu.pop());                
            }
            st.add(x);
            while(!st.isEmpty()){
                qu.add(st.pop());                
            }
        }
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return qu.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return qu.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(qu.isEmpty())
            return true;
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
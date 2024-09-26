// Time Complexity : O(1) for pop(), peek(), isEmpty(), O(1) amortized, O(N) worst case for push()
// Space Complexity : O(N) for the 2 stacks
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// use stack 1 to push() elements, on pop()/peek() unload to s2 if s2 is empty(), return top

class MyQueue {
    
    Stack<Integer> s1;
    Stack<Integer> s2;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    //O(1)
    public void push(int x) {
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    //O(N) worst case, O(1) amortized
    public int pop() {
        peek();
        
        if(s2.isEmpty())
            return -1;
        
        return s2.pop();
    }
    
    /** Get the front element. */
    //O(N) worst case, O(1) amortized
    public int peek() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        
        if(s2.isEmpty())
            return -1;
        
        return s2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
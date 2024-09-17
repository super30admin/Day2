// Time Complexity : O(N)  - Push O(1), Pop O(N), Peek O(N), Empty O(1)
// Space Complexity : O(N) - No of elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, straightforward

class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    int front;
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }// Takes O(N) time, we add the previous elemnts into auxillary stack and then move all back.
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(s2.isEmpty())
       {
           while(!s1.isEmpty()){
               s2.push(s1.pop());
           }
       }
       return s2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(s2.isEmpty())
       {
           while(!s1.isEmpty()){
               s2.push(s1.pop());
           }
       }
       return s2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
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
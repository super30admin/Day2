// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach




class MyQueue {
    Stack<Integer> a = new Stack<>();
    Stack<Integer> b = new Stack<>();
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!a.isEmpty()){
            b.push(a.pop());
        }
        a.push(x);
        
        while(!b.isEmpty()) {
            a.push(b.pop());
        }

    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
         if(a.isEmpty()) {
            return -1;
       }
       else {
           int x = a.pop();
           return x;
       }

    }
    
    /** Get the front element. */
    public int peek() {
        if(a.isEmpty()) {
            return -1;
       }
       else {
           int x = a.peek();
           return x;
    }
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
         if(a.isEmpty()){
            return true;
        }
        else {
            return false;
        }

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
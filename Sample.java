// Time Complexity :O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach
class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> s1,s2;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!s2.empty())
        {
            s1.push(s2.pop());
        }
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!s1.empty())
        {
            s2.push(s1.pop());
        }
        int x= s2.peek();
        s2.pop();
        return x;
    }
    
    /** Get the front element. */
    public int peek() {
        while(!s1.empty())
        {
            s2.push(s1.pop());
        }
       int x= s2.peek();
        return x;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(!s1.empty() || !s2.empty()) return false;
         return true;   
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
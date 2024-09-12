// Time Complexity : O(n) for push and O(1) for others
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :  Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyQueue {
    
    private int front;
    Stack<Integer> s1;
    Stack<Integer> s2;
    

    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    
    public void push(int x) {
        if(s1.isEmpty())
            front = x;
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s2.push(x);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int val = s1.pop();
        if(!s1.isEmpty())
            front = s1.peek();
        return val;        
    }
    
    /** Get the front element. */
    public int peek() {
        return front;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
}

// Time Complexity : push - O(1), pop- O(N), peek - O(N), empty-O(1)
// Space Complexity :O(n) - For creating stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No




class MyQueue {

    /** Initialize your data structure here. */
    private Stack<Integer> s1= new Stack<>();   // Implementing queue using 2 stacks
    private Stack<Integer> s2= new Stack<>();  // In s2 , queue is maintained
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x); //new element is pushed into s1
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(s2.isEmpty()){  // while popping, if s2 is not empty, top element is just popped,If s2 is empty, all the elements from s1 is emptied into s2 and then the top element is popped
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
        
    }
    
    /** Get the front element. */
    public int peek() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }// while peeking, if s2 is not empty, s2 is peeked,If s2 is empty, all the elements from s1 is emptied into s2 and then the top element is returned
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
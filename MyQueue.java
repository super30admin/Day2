// Time Complexity : push() - O(1), pop() - O(1) average and peek() - O(1) average.
//Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : No

class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> In;
    Stack<Integer> Out;
    public MyQueue() {
        In = new Stack<Integer>();
        Out = new Stack<Integer>();        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        In.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return Out.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(Out.isEmpty())
        {
            while(!In.isEmpty())
            {
                Out.push(In.pop());
            }
        }
        return Out.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return In.isEmpty() && Out.isEmpty();
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
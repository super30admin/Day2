import java.util.Stack;

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class ImplementQueueUsingStacks_232{

    Stack<Integer> st1;
    Stack<Integer> st2;
    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks_232() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        this.st1.push(x);       
    }
    
    public void transfer(Stack s1, Stack s2) {
        int x;
        int size= s1.size();
        for(int i=0;i<size;i++){
            x= (int) s1.pop();
            s2.push(x);
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(this.st2.isEmpty()){
            transfer(this.st1,this.st2);
        }
            return this.st2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
         if(st2.isEmpty()){
            transfer(this.st1,this.st2);
        }
            return st2.peek();
    }

    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.st1.isEmpty() && this.st2.isEmpty();
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
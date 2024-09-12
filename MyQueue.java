// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach




import java.util.Stack;
class MyQueue {

    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int poppedItem=s2.pop();
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return poppedItem;
    }
    
    /** Get the front element. */
    public int peek() {
         while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int peekedElement=s2.peek();
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return peekedElement;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(s1.isEmpty() && s2.isEmpty()){
            return true;
        }
        else{
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
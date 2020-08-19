//Implement queue using stacks
// Time Complexity :push-O(1), pop-O(1), peek- O(n)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class MyQueue {

    private Stack<Integer> pushstack;
    private Stack<Integer> popandpeek;
    /** Initialize your data structure here. */
    public MyQueue() {
        pushstack=new Stack();
        popandpeek = new Stack();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        pushstack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(popandpeek.isEmpty()) {
            while(!pushstack.isEmpty()) {
                popandpeek.push(pushstack.pop());
            }
        }
        return popandpeek.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(popandpeek.isEmpty()) {
            while(!pushstack.isEmpty()) {
                popandpeek.push(pushstack.pop());
            }
        }
        return popandpeek.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return pushstack.isEmpty() && popandpeek.isEmpty();
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

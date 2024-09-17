// Time Complexity : Amortized O(1) for all operations 
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : Yes, storing it in another stack was tricky, got exception for peek, then it got clear after the class that inserting elements
//into second stack should actually happen at peek and then re-used at pop


// Your code here along with comments explaining your approach

class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> first;
    Stack<Integer> second;
    public MyQueue() {
        first = new Stack<>();
        second = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        first.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return second.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(second.isEmpty()){
            while(!first.isEmpty()){
                second.push(first.pop());
            }
        }
        return second.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return first.isEmpty() && second.isEmpty();
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

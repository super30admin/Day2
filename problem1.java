// Time Complexity :all operations are amortized O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MyQueue {

     private Stack<Integer> stack1;
     private Stack<Integer> stack2;
    
    /** Initialize your data structure here. */
    public MyQueue() {
       stack1 = new Stack<>();
       stack2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
      stack1.push(x);    //push elements to the stack1
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return stack2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(stack2.isEmpty()) {       //push all elements from stack1 to stack2 only if stack2 is empty
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();  //If both queues are empty, the Queue is empty
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
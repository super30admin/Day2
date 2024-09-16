// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : desiging the instance of this.push() and stack.push()


// Your code here along with comments explaining your approach
class MyQueue {

    Stack <Integer> stack;
    
    /** Initialize your data structure here. */
    public MyQueue() {
     stack = new Stack<>();    
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(stack.empty())
            stack.push(x);
        else {
            int number = stack.pop();
            this.push(x);
            stack.push(number);
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.empty();
    }
}


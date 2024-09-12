// Time Complexity : push-O(1), pop and peek - Amortized Most of the times O(1) worst O(n)
// Space Complexity : O(2n) = O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// 1. take 2 stacks
// 2. keep inserting element into stack1
// 3. while popping if stack2 is empty then push all elements from stack1 to stack2 and keep popping elements from stack2 whenever we have next pop/peek operations next till stack2 becomes empty
class MyQueue {
    //create 2 stacks
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(empty())
            return -1;
        if(stack2.isEmpty())
            transfer();
        return stack2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(empty())
            return -1;
        if(stack2.isEmpty())
            transfer();
        return stack2.peek();
    }
    
    public void transfer(){
        while(!stack1.isEmpty())
            stack2.push(stack1.pop());
    }
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
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

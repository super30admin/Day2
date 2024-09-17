// Time Complexity : O(1) time for all functions - push(),  peek(), empty(). O(N) or O(1) amortized for pop()
// Space Complexity : 2 stacks = O(2N) = O(N)
// Did this code successfully run on Leetcode : Yes
class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int peekElement;
    
    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if (stack1.isEmpty())
            peekElement = x;
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // If stack2 is empty, then transfer all the data from stack1 to stack2 first and then pop the top element from stack2, otherwisse just pop() from stack2. Also, peek element is tracked which will be equal to stack2's top element if stack2 is not empty
            
        if (stack2.isEmpty())
        {
            while(!stack1.isEmpty())
            {
                stack2.push(stack1.pop());
            }
        }
        int poppedElement = stack2.pop();
        
        if (!stack2.isEmpty())
           peekElement = stack2.peek();

        return poppedElement;
    }
    
    /** Get the front element. */
    public int peek() {
        return peekElement;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (stack1.isEmpty() && stack2.isEmpty());
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

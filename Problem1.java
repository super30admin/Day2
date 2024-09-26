//Problem 1: Implement queue using stacks
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Worked on this for 1 hour and then watched video to understand the concept

// Your code here along with comments explaining your approach :
// Taking 2 stacks, one stack for enqueuing and second stack mainly used for dequeuing
// 2 stacks are used because the basic rule in queue is FIFO and in stack is LIFO.
// After inserting elements in the queue, if we want to remove an element, 
// whichever is inserted first should be removed or popped. 
// Since stack pops elements which are at the top. 
// This can be achieved by using second stack and there will be reverse of elements and the top element can be popped.

class MyQueue {
   Stack<Integer> stack1;
   Stack<Integer> stack2;
   int front=0;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();

    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(stack1.isEmpty())
        {
            front = x;
        }
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack2.isEmpty()) 
        {
            while (!stack1.isEmpty())
            {
                int a = stack1.pop();
                stack2.push(a);
            }
        }
        return stack2.pop();    
    }
    
    /** Get the front element. */
    public int peek() {
            if(stack1.isEmpty())
            {
                if(!stack2.isEmpty())
                {
                    return stack2.peek();
                }
            }
        return front;
    }
    
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stack1.isEmpty() && stack2.isEmpty())
            return true;
        else
            return false;
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
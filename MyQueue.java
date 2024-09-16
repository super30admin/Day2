//Time Complexity : O(n) pop
//Space Complexity : O(n) 
// It did run successfully on Leetcode
// Problems :  No problem




/*
Here we are maintaining 2 stacks. Whenever we need to pop out the elements in fifo manner, we'll transfer elemets to out
stack and pop it from there.
 */


class MyQueue {
    Stack<Integer> inStack;
    Stack<Integer> outStack;
    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!outStack.empty())return outStack.pop();
        else
        {
            while(!inStack.empty())
            {
                outStack.push(inStack.pop());
            }
            return outStack.pop();
        }
    }

    /** Get the front element. */
    public int peek() {
        if(!outStack.empty())return outStack.peek();
        else
        {
            while (!inStack.empty())
            {
                outStack.push(inStack.pop());
            }
            return outStack.peek();
        }
    }

    public boolean empty() {
        if(inStack.empty() && outStack.empty())return true;
        else return false;
            
    }
}


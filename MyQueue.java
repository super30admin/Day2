// Time Complexity : O(1) where pop operation O(n) is amortized to O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class MyQueue {
    
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue()
    {
        inStack = new Stack<Integer>();
        outStack = new Stack<Integer>();
    }

    public void push(int x)
    {
        inStack.push(x); // we always push to inStack
    }

    // Since Queue is FIFO, inStack does not old first value hence re-arrange
    public int pop()
    {
        peek(); // since we need to do the same operation
        return outStack.pop();
    }


    public int peek()
    {
        if(outStack.isEmpty()) // first element re-order instack
        {
            while(!inStack.isEmpty())
            {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }
}

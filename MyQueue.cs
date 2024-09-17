// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class MyQueue {
    
    Stack<int> inStack = null;
    Stack<int> outStack = null;

    public MyQueue() {
        inStack = new Stack<int>();
        outStack = new Stack<int>();
    }
    
    //O(1)
    //add all element to inStack
    public void Push(int x) {
        inStack.Push(x);
    }
    
    //O(1)
    //transfer all elements from instack to outstack to pop element, only if outstack is empty
    //transfer happens only in worst case
    public int Pop() {
        transferElements();
        return outStack.Pop();
    }
    
    //O(1)
    //transfer all elements from instack to outstack to peek element, only if outstack is empty
    //transfer happens only in worst case
    public int Peek() {
        transferElements();
        return outStack.Peek();
    }
    
    private void transferElements()
    {
        if(outStack.Count == 0)
        {
            while(inStack.Count != 0)
            {
                outStack.Push(inStack.Pop());
            }
        }
    }
    
    public bool Empty() {
        return inStack.Count == 0 && outStack.Count == 0;
    }
}
/**

// Time Complexity :
    push- O(1)
    pop - amortized O(1) if the popStack is empty and pop needs to perform then need to transfer from pushStack to popStack linearly. 
    top - O(1)
    getMinimum O(1) 
// Space Complexity :
    Total space complexity = in worst case O(2n - 1) where n is the size of stack. Wrst case happens when incoming elements is alway <= minSofar.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

**/
class MyQueue {
    
    Stack<Integer> pushStack;
    Stack<Integer> popStack;
    
    public MyQueue() {
        
        pushStack = new Stack<>();
        popStack = new Stack<>();
        
    }
    
    public void push(int x) {
        
        pushStack.push(x);
    }
    
    private void transferElementsFromPushToPop()
    {
        if (popStack.isEmpty())
        {
            // push elements from pushStack to popStack
            while(!pushStack.isEmpty())
            {
                popStack.push(pushStack.pop());
            }
        }
    }
    
    public int pop() {
        
        if (empty())
        {
            return -1;
        }
       
        transferElementsFromPushToPop();
        return popStack.pop();
    }
    
    public int peek() {
        
        if (empty())
        {
            return -1;
        }
        
        transferElementsFromPushToPop();
        return popStack.peek();
    }
    
    public boolean empty() {
        
        return pushStack.isEmpty() && popStack.isEmpty();
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
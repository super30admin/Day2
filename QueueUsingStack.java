// Time Complexity : push to queue (o(1)), pop o(n), peek o(n), empty o(1)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Edge case with empty was incorrect but later I fixed it.


// Your code here along with comments explaining your approach
// Use 2 stack, 1 for push and 1 for pop. Since queue works on FIFO ad Stack work on FILO approach, we will use 2 stack. 
// we will keep pushing the item in inStack, as soon as pop happens, we will first all items from inStack to outStack and return outStack.peek()
// This whichever Item went first in queue will be popped up.
// This is solution I wrote in leetcode.
class MyQueue {
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public MyQueue() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
        
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        peek();
        return outStack.pop();
        
    }
    
    public int peek() {
        if(outStack.isEmpty()) {
            while(!inStack.isEmpty())
            outStack.push(inStack.pop());
        }
        return outStack.peek();
    }
    
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
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

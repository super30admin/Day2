// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class MyQueue {
    
    Stack<Integer> in, out;

    /** Initialize your data structure here. */
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        //pushing to instack
        in.push(x);
        
    }
    
    //helper function to transfer from Instack to OutStack
    private void transfer(Stack<Integer> inStack, Stack<Integer> outStack)
    {
       while(!inStack.isEmpty()){
           outStack.push(inStack.pop());
       }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //Transfer from instack to outstack for pop
        if(out.isEmpty())
            transfer(in, out);
        return out.pop();
        
    }
    
    /** Get the front element. */
    public int peek() {
        //Transfer from instack to outstack for pop
                if(out.isEmpty())
            transfer(in, out);
        return out.peek();

    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
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

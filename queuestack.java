// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
implemented the code by creating two stacks instack and outstack and pushing the elements to outstack when pop was needed making th outack a queue */

class MyQueue {
    Stack<Integer> inst;
    Stack<Integer> outst;
    public MyQueue() {
        this.inst = new Stack<>();
        this.outst = new Stack<>();
    }
    
    public void push(int x) {
        inst.push(x);
    }
    
    public int pop() {
        if(outst.empty())
        {
            while(!inst.empty())
            {
                outst.push(inst.pop());
            }
        }
        return outst.pop();
    }
    
    public int peek() {
        if(outst.empty())
        {
            while(!inst.empty())
            {
                outst.push(inst.pop());
            }
        }
        return outst.peek();
    }
    
    public boolean empty() {
        return (outst.empty() && inst.empty());
    }
}
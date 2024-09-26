// Time Complexity : Amortized O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyQueue {

    private Stack<Integer> instack;
    private Stack<Integer> outstack;
    
    public MyQueue() {
        this.instack = new Stack<>();
        this.outstack = new Stack<>();
    }
    
    public void push(int x) {
        instack.push(x);
    }
    
    public int pop() {
        if (outstack.isEmpty()) {
            // transfer elements from instack and remove the last element from instack
            while (instack.size() > 1) {
                outstack.push(instack.pop());
            }
            
            return instack.pop();
        }
        
        return outstack.pop();
    }
    
    public int peek() {
        if (!outstack.isEmpty()) {
            return outstack.peek();
        }
        
        while (!instack.isEmpty()) {
            outstack.push(instack.pop());
        }
        
        return outstack.peek();
    }
    
    public boolean empty() {
        return outstack.isEmpty() && instack.isEmpty();
    }
}
// Time Complexity : The time complexity will be logarithmic.
// Space Complexity : 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


class MyQueue {
    Stack<Integer> inSt;
    Stack<Integer> outSt;

    public MyQueue() {
        this.inSt=new Stack<>();
        this.outSt=new Stack<>();
        
    }
    
    public void push(int x) {
        inSt.push(x);
        
    }
    
    public int pop() {
        peek();
        return outSt.pop();
        
    }
    
    public int peek() {
        if(outSt.isEmpty()){
            while(!inSt.isEmpty()){
                outSt.push(inSt.pop());
            }
        }
        return outSt.peek();
        
    }
    
    public boolean empty() {
        return  inSt.isEmpty() && outSt.isEmpty();        
    }
}


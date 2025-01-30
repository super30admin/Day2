//Time Complexity :o(1)
// Space Complexity :o(1) 
// Did this code successfully run on Leetcode : it runs good in leat code
// Any problem you faced while coding this : no

class MyQueue {
 Stack <Integer>inStack;
 Stack<Integer>outStack;
    public MyQueue() {
        inStack=new Stack<>();
        outStack= new Stack<>();   
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
    //     if(outStack.isEmpty()){
    //         while(!inStack.isEmpty()){
    //             outStack.push(in.Stack.pop());
    //         }
    //        return outStack.peak();
    //     }
    //    return outStack.pop();
     peek();
     return outStack.pop();   
    }
    
    public int peek() {
        // front of queue;
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
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
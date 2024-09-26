// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyQueue {
    Stack <Integer> inStack;
    Stack <Integer> outStack;

    public MyQueue() {
        inStack = new Stack <>();
        outStack = new Stack <>();
    }
    
    public int push(int x) {
        inStack.push(x);
    }

    public void pop () {
        if(outStack.isEmpty()) {
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop()){
                }
            }
            outStack.pop();
        }
    }

    public int peek(){
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean empty(){
        return outStack.isEmpty() && inStack.isEmpty();
    }
}
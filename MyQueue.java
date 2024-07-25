// Time Complexity : push - O(1), pop - 0(1), peek - 0(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyQueue {

    Stack<Integer> primaryStack;
    Stack<Integer> secStack;

    public MyQueue() {
        primaryStack = new Stack();
        secStack = new Stack();
    }
    
    public void copyStack(){
        while(!primaryStack.isEmpty()){
            secStack.push(primaryStack.pop());
        }
    }

    public void push(int x) {
        primaryStack.push(x);
    }
    
    public int pop() {
        
        if(secStack.isEmpty()){
            copyStack();
        } 
        
        return secStack.pop();
    }
    
    public int peek() {
        if(secStack.isEmpty()){
            copyStack();
        } 
        return secStack.peek();
    }
    
    public boolean empty() {
        return primaryStack.isEmpty() && secStack.isEmpty();
    }
}
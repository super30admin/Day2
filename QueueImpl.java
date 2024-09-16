// Time Complexity : Push-O(1), Pop-Amortized O(1), Peek-Amortized O(1)
// Space Complexity : O(n)  (for the extra stack)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing specific

class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> pushStack;
    Stack<Integer> poppeekStack;
    public MyQueue() {
        pushStack=new Stack<>();
        poppeekStack=new Stack<>();
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        pushStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(poppeekStack.isEmpty()){
            while(!pushStack.isEmpty()){
                poppeekStack.push(pushStack.pop());
            }
        }
        return poppeekStack.isEmpty() ? Integer.MAX_VALUE : poppeekStack.pop();
        
    }
    
    /** Get the front element. */
    public int peek() {
        if(poppeekStack.isEmpty()){
            while(!pushStack.isEmpty()){
                poppeekStack.push(pushStack.pop());
            }
        }
        return poppeekStack.peek();  
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return poppeekStack.isEmpty() && pushStack.isEmpty();
        
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
// Time Complexity : O(1)  - Amortized
 // Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO
class MyQueue {
    
    Stack<Integer> pushstack;
    Stack<Integer> popstack;
    public MyQueue() {
        pushstack = new Stack<>();
        popstack = new Stack<>();
    }
    
    public void push(int x) {
        pushstack.push(x);
    }
    
    public int pop() {
        if(popstack.isEmpty()){
            if(pushstack.isEmpty()){
                return -1;
            }
            while(!pushstack.isEmpty()){
                popstack.push(pushstack.pop());
            }
        }
        return popstack.pop();
    }
    
    public int peek() {
        if(popstack.isEmpty()){
            if(pushstack.isEmpty()){
                return -1;
            }
            while(!pushstack.isEmpty()){
                popstack.push(pushstack.pop());
            }
        }
        return popstack.peek();
    }
    
    public boolean empty() {
        if(pushstack.isEmpty() && popstack.isEmpty()){
            return true;
        }
        return false;
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

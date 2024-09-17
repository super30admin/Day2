/*
    Push Time Complexity: O(1)
    Pop Time Complexity: O(n)
    Peek Time Complexity: O(1)

    Space Time Complexity: O(n)
    
    Accepted Leetcode URL: https://leetcode.com/submissions/detail/632542034/
*/
class MyQueue {
    
    Stack<Integer> enqueueStack;
    Stack<Integer> dequeueStack;
    
    public MyQueue() {
        this.enqueueStack = new Stack<>();
        this.dequeueStack = new Stack<>();
    }
    
    public void push(int x) {
        this.enqueueStack.push(x);
    }
    
    public int pop() {
        while(this.enqueueStack.size() != 1){
            this.dequeueStack.push(this.enqueueStack.pop());
        }
        
        int rv = this.enqueueStack.pop();
        
        while(this.dequeueStack.size() > 0){
            this.enqueueStack.push(this.dequeueStack.pop());
        }
        
        return rv;
    }
    
    public int peek() {
        while(this.enqueueStack.size() != 1){
            this.dequeueStack.push(this.enqueueStack.pop());
        }
        
        int rv = this.enqueueStack.peek();
        
        while(this.dequeueStack.size() > 0){
            this.enqueueStack.push(this.dequeueStack.pop());
        }
        
        return rv;
    }
    
    public boolean empty() {
        return this.enqueueStack.size() == 0;
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

// Time Complexity : O(n) 
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
class MyQueue {
    // initializing the 2 stacks that we will be using
    Stack<Integer> in; 
    Stack<Integer> out; 
    
    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }
    
    public void push(int x) {
        in.push(x); 
    }
    // the logic is to pop all elements from the in stack and push them in the out stack to the get the FIFO pattern when 
    //returning and removing the front most element. 
    public int pop() {
        if(out.isEmpty()) {
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.pop(); //if out not empty return the top most element
    }
    
    public int peek() {
        if(out.isEmpty()) {
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek(); // if out not empty return the top most element
    }
    
    public boolean empty() {  
        return out.isEmpty() && in.isEmpty();  //when both the stacks are empty only then the queue is empty
        
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
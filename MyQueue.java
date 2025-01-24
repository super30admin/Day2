// Time Complexity :
// push : O(1)
// pop/peek  : Amortized O(1)
// Space Complexity : O(N) - two stacks holding N queue elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

  class MyQueue {
    Stack<Integer> inStack;
    Stack<Integer> outStack;


    public MyQueue() {   
       inStack = new Stack<>();
       outStack = new Stack<>();
    }
    
    public void push(int x) {

        inStack.push(x);
        
    }
    
    public int pop() {

    if(outStack.isEmpty()){

          while(!(inStack.isEmpty())){

            outStack.push(inStack.pop());
          }
        }        
        return outStack.pop();
    }
    
    public int peek() {

        //front of queue

        if(outStack.isEmpty()){

          while(!(inStack.isEmpty())){

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

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyQueue {
    
    Stack<Integer> in = new Stack<>();  // in stack
    Stack<Integer> out = new Stack<>();  //out stack

    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
         if(out.isEmpty()){
           while(!in.empty()) {  
               out.push(in.pop());
            }
        }
        return  out.pop();
    }
    
    /** Get the front element. */
    public int peek() {
         if(out.isEmpty()){
           while(!in.empty()) {  
               out.push(in.pop());
            }
        }
        return  out.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
         return in.empty() && out.empty();
    }
}

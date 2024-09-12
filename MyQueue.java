/**Time Complexity :
    O(1)
// Space Complexity :
    O(1)
// Did this code successfully run on Leetcode :
    Yes
// Any problem you faced while coding this :   
   No
// Your code here along with comments explaining your approach
**/


class MyQueue {

    //Declaration of 2 stack one for input and one for output
    Stack<Integer> in;
    Stack<Integer> out;

    //Initialization
    public MyQueue() {
        in=new Stack<>();
        out=new Stack<>();
    }
    
    //push element in input stack
    public void push(int x) {
        in.push(x);
    }
    
    //pop element but from out stack as it maintains the queue structure which is FIFO
    public int pop() {
        peek();
        return out.pop();
    }
    
    //to written top element and to push element in out stack if in stack is not empty.
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
            
        }
        return out.peek();
        
    }
    
    //to check if stack is empty
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
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
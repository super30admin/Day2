// Time Complexity : O(1) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;
    public MyQueue() {
        //initialize two stacks for implementing queue
        // "in" is the main stack and out is used for performing pop and peek operations of queue.
        in = new Stack<>();
        out= new Stack<>();
    }
    
    public void push(int x) {
        //In push method, data is diretly added to the main stack.
        in.push(x);
    }
    
    public int pop() {
        // while performing pop operation, this method will check if the out stack is empty, then it will shift all the elements in the in stack to out stack.
        // then  pop operation for queue is done on the out stack
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.pop();
    }
    
    public int peek() {
        //same logic what we have used to pop the element is used to find the peek element 
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    public boolean empty() {
        //if both the stacks are empty -> queue is empty
        if(out.isEmpty()&&in.isEmpty()){
            return true;
        }
        else{
            return false;
        }
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
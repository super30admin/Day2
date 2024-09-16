// Time Complexity : ~ O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//maintaining two stacks. push operation always pushes to in stack. pop/peek opertaion checks if out has any element it will return that otherwise pop
//all elements from in and push them in out using helper stack in the same order and then do pop/peek. Empty checks if both the stack are emprty, return
//true , otherwise false.

class MyQueue {
    
    private Stack<Integer> in;
    private Stack<Integer> out;
    
    public MyQueue() {
        in = new Stack<Integer>();
        out = new Stack<Integer>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        if(!out.empty())
            return out.pop();
        else if(!in.empty()){
            helper();
            return out.pop();
        }
        return -1;
    }
    
    public int peek() {
        if(!out.empty())
            return out.peek();
        else if(!in.empty()){
            helper();
            return out.peek();
        }
        return -1;
    }
    
    public void helper(){
        while(!in.empty()){
            int popped = in.pop();
            out.push(popped);
        }
    }
    
    public boolean empty() {
        return in.empty() && out.empty();
    }
}

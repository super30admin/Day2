// Time Complexity : O(1) - average
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach
// Since stack is last in first out (LIFO) and queue is First in first out (FIFO),
// To peek or pop first element, copy all the element from one stack to other and to ,
// push element push it on first stack

class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;
    public MyQueue(){
        in = new Stack<>();
        out = new Stack<>();
    }
    
    public void push(int x) {
        in.push(x);
    }

    // pop elements from in stack and push them on out statck until in stack is empty
    // pop first element from out stack
    public int pop() {
        if(out.empty()){
            while(!in.empty()){
                out.push(in.pop());
                }
        }
        return out.pop();
    }
    
    // Pop elements from in stack and push them on out statck until in stack is empty
    // Peek first element from out stack
    public int peek() {
        if(out.empty()){
            while(!in.empty())
                out.push(in.pop());
                
        }
        return out.peek();
    }
    
    public boolean empty() {
        return (in.empty() && out.empty());
    }
}

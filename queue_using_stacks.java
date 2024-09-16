
// Time Complexity : o(1)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes
class MyQueue {
    
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();   
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        peek(); // re-using peek() we have written down, note that we'l be using only the if statement part the value peek() returns is unnneccesary
        return out.pop();
    }
    
    public int peek() {
        if(out.isEmpty()) {
            while(!in.isEmpty()){
                out.push(in.pop());
            }       
        }
        return out.peek(); // we're using in-built function .peek() here
    }
    
    public boolean empty() {
        return (in.isEmpty() && out.isEmpty());
    }
}


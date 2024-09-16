// Time Complexity : o(1)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// design queue using stack
class MyQueue {
    
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<Integer>();
        out = new Stack<Integer>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        if(Integer.MAX_VALUE != peek()){
            return out.pop();
        }
        return Integer.MAX_VALUE;
    }
    
    public int peek() {
        if(!empty()){
            if(out.isEmpty()){
                while(!in.isEmpty()){
                    out.push(in.pop());
                }
            }
            return out.peek();
        }
        return Integer.MAX_VALUE;
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
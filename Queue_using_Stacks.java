// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MyQueue {

    private Stack<Integer> in , out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    private void transferIfRequired(){

        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }

    }
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        transferIfRequired();
        return out.pop();
    }
    
    public int peek() {
        transferIfRequired();
        return out.peek();
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
// Time Complexity : O(1) Since it is a data structure and not an algorithm
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyQueue {
    Stack<Integer> inst;
    Stack<Integer> outst;
    public MyQueue() {
        inst = new Stack<>();
        outst = new Stack<>();
    }
    
    public void push(int x) {
        inst.push(x);
    }
    
    public int pop() {
        peek();
        return outst.pop();
    }
    
    public int peek() {
        if(outst.isEmpty()){
            while(!inst.isEmpty()){
                outst.push(inst.pop());
            }
        }
        return outst.peek();
    }
    
    public boolean empty() {
        if(outst.isEmpty() && inst.isEmpty()){
            return true;
        }
        return false;
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

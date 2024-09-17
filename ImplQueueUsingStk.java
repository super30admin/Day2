// Time Complexity : push => o(1), pop => amortized[o(1)] worst[o(n)], peek => amortized[o(1)] worst[o(n)], isEmpty() => o(1)
// Space Complexity : worst => o(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

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
    
    public void transfterInToOut() {
        while(!in.isEmpty()) {
            int x = in.pop();
            out.push(x);
        }
    }
    
    public int pop() {
        if(empty()) return 0;
        int x = 0;
        if(!out.isEmpty()) {
            x = out.pop();
        } else if(!in.isEmpty() && out.isEmpty()) {
            transfterInToOut();
            x = out.pop();
        }
        return x;
    }
    
    public int peek() {
        if(empty()) {
            return 0;
        }
        int x = 0;
        if(!out.isEmpty()) {
            x = out.peek();
            return x;
        }
        else if(!in.isEmpty() && out.isEmpty()) {
            transfterInToOut();
            x = out.peek();
            return x;
        }
        return 0;
    }
    
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
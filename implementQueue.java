// Time Complexity : O(1) for push and empty
// O(n) for peek and pop
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


import java.util.*;
class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;
    
    public MyQueue() {
        in = new Stack();
        out = new Stack();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        if(out.isEmpty()) {
            while(!in.isEmpty()){
                int n = in.peek();
                in.pop();
                out.push(n);
            }
        }
        int n = out.peek();
        out.pop();
        return n;
    }
    
    public int peek() {
        if(out.isEmpty()) {
            while(!in.isEmpty()){
                int n = in.peek();
                in.pop();
                out.push(n);
            }
        }
        return out.peek();
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
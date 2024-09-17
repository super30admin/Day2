// Time Complexity : push - O(1), pop and peek - O(n), empty - O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no





import java.util.*;
class QueueStack {
    Stack<Integer> in = new Stack<Integer>();
    Stack<Integer> out = new Stack<Integer>();

    public QueueStack() {
        
    }
    
    public void push(int x) {
           in.push(x);
    }
    
    public int pop() {
        peek();
        return out.pop();
    }
    
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    public boolean empty() {
        return in.isEmpty()&&out.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * QueueStack obj = new QueueStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Used 2 stacks, every pop and every peek operation I used another stack to store it again in rev order.

import java.util.*;

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
        while(!in.isEmpty()){
            out.push(in.pop());
        }
        int x = out.pop();
        while(!out.isEmpty()){
                in.push(out.pop());
        }
        return x;
    }
    
    public int peek() {
        while(!in.isEmpty()){
            out.push(in.pop());
        }
        int x = out.peek();
        while(!out.isEmpty()){
            in.push(out.pop());
        }
        return x;
    }
    
    public boolean empty() {
        if(in.isEmpty()){
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
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

import java.util.Stack;

class MyQueue {
    
    private Stack<Integer> enter;
    private Stack<Integer> exit;

    public MyQueue() {
        enter=new Stack<>();
        exit=new Stack<>();
    }
    
    public void push(int x) {
        enter.push(x);
    }
    
    public int pop() {
        if(exit.isEmpty())
        {
            while(!enter.isEmpty())
            {
                exit.push(enter.pop());
            }
        }
        return exit.pop();
        
    }
    
    public int peek() {
        if(exit.isEmpty())
        {
            while(!enter.isEmpty())
            {
                exit.push(enter.pop());
            }
        }
        return exit.peek();
    }
    
    public boolean empty() {
        return enter.isEmpty() && exit.isEmpty();
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


 
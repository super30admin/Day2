// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : while pop and push I had issue for [push, push, peek, pop, isEmpty] 


// Your code here along with comments explaining your approach
import java.util.Stack;
class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack();
        s2 = new Stack();
    }
    
    public void push(int x) {
        if(s2.isEmpty()){
            s1.push(x);
        }else{
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
            s1.push(x);
        }
    }
    
    public int pop() {
        if(!s2.isEmpty()){
            return s2.pop();
        }else{
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.pop();
        }
    }
    
    public int peek() {
        if(!s2.isEmpty()){
            return s2.peek();
        }else{
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.peek();
        }
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
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
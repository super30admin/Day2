// Time Complexity :average case- push-O(1) and pop O(1)
// Space Complexity : 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
import java.util.*;
class MyQueue {
    Stack <Integer> first;
    Stack<Integer> second;
    public MyQueue() {
        first= new Stack<>();
        second= new Stack<>();
    }
    
    public void push(int x) {
        first.push(x);
    }
    
    public int pop() {
        peek();
        return second.pop();
        
    }
    
    public int peek() {
        if(second.isEmpty()){
            while(!first.isEmpty()){
                second.push(first.pop());
            }
        }
        return second.peek();
    }
    
    public boolean empty() {
        return (first.isEmpty()) && (second.isEmpty());
    }
}

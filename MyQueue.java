/*
 * Time Complexity :O(N) for pop and peek and O(1) for push
 * Space Complexity : O(N) for 2 stacks
 * Did this code successfully run on Leetcode : YES
 * Any problem you faced while coding this :no
 */
import java.util.*;
class MyQueue {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();
    public MyQueue() {
        
    }
    //Aleways on input stack
    public void push(int x) {
        input.push(x);
    }
    //We perform peek to populate output, if its empty
    public int pop() {
        peek();
        return output.pop();
    }
    //This function is responsible to make sure there are always 
    //elements present in the output stack via which we perfrom peek and pop on the queue
    public int peek() {
        if(output.empty()){
            while(!input.empty()){
                output.push(input.pop());
            }
        }
        return output.peek();
    }
    
    public boolean empty() {
        return output.empty() && input.empty();
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
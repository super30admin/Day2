// Overall Time Complexity : O (1) . The push, pop and peek operations happens in O(1).
// Overall Space Complexity : O(n) . The space complexity of storing the values in two stacks is O(n+n) ie O(2n).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No issues faced during implementation


// The solution to the problems involves using two stacks i.e one stack to keep pushing the current elements and the other helper stack helps 
// simulating the behaviour of the Queue by popping all the values from stack one whenever a peek function is called.

import java.util.*;
class Queue {
    Stack<Integer> st_one;
    Stack<Integer> st_two; 

    public Queue() {
        this.st_one = new Stack<>();
        this.st_two = new Stack<>();
        
    }
    
    public void push(int x) {
        st_one.push(x);
    }
    
    public int pop() {
        peek();
        return st_two.pop();

        
    }
    
    public int peek() {
        if(st_two.isEmpty()){
            while(!st_one.isEmpty()){
                st_two.push(st_one.pop());
            }
        }
        return st_two.peek();
        
    }
    
    public boolean empty() {

        return st_one.isEmpty() && st_two.isEmpty();
        
    }
}
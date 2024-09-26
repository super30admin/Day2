// Time Complexity :push[O(n)], pop[O(1)], peek[O(1)], empty[O(1)]
// Space Complexity :
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

/*
@auther = PRAYAG PATEl
@Problem = S30 FAANMG Problem #3{easy}, 232. Implement Queue using Stacks
@asked = Microsoft
*/

/**@approach
 * using two stack to implement Que
 * for enQueue coping the content of queue stack into Operational Stack --> push new elemnt into queue_stack -->copy back elemnts from oprerational stack into queue stack
 * pop,peek and empty operation performed as usual time
 * 
 * */


import java.util.*;
class MyQueue {
    private Stack<Integer>queue_Stack;
    private Stack<Integer>operaional_Stack; 
    public MyQueue() {
    queue_Stack = new Stack<>();
    operaional_Stack= new Stack<>();
   }
    
    public void push(int x) {
        while(!queue_Stack.isEmpty()){
            operaional_Stack.push(queue_Stack.pop());
        }
        queue_Stack.push(x);
        while(operaional_Stack.isEmpty()){
            queue_Stack.push(operaional_Stack.pop());
        }
        
    }
    
    public int pop() {
        if(!queue_Stack.isEmpty()){
            return queue_Stack.pop();
        }
        return 0;
    }
    
    public int peek() {
        if(!queue_Stack.isEmpty()){
            return queue_Stack.peek();
        }
        return 0;
    }
    
    public boolean empty() {
        if(!queue_Stack.isEmpty()){
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